/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.business;

import cl.fseguel.awtolog.model.repository.HastagsRepository;
import org.springframework.stereotype.Service;
import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.entity.AwlogLogger;
import cl.fseguel.awtolog.model.entity.AwlogLoggerHashtag;
import cl.fseguel.awtolog.model.repository.AwtoLogRepository;
import cl.fseguel.awtolog.model.util.Constantes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogBusinessImpl implements AwtoLogBusiness {

    @Autowired
    private HastagsRepository hastagsRepository;
    @Autowired
    private AwtoLogRepository awtoLogRepository;

    /**
     * @see PUT /hastags:
     *
     * No debe permitir la modificación de un hashtag repetido. En el caso que
     * ya exista, debe retornar BAD_REQUEST con un mensaje apropiado.
     *
     * La descrición del hashtag no debe ser vacía, de lo contrario retornar
     * BAD_REQUEST con un mensaje apropiado.
     *
     */
    @Override
    public String saveHastags(Hastags hastags) {
        AwlogHashtag hash = new AwlogHashtag();
        hash.setId(BigDecimal.valueOf(hastags.getId()));
        hash.setDescription(hastags.getDescripcion());

        List<AwlogHashtag> lista = hastagsRepository.findByDescription(hastags.getDescripcion());
        if (CollectionUtils.isNotEmpty(lista)) {
            if (lista.size() > 1) {
                return Constantes.BAD_REQUEST;
            } else {
                hastagsRepository.save(hash);
                return Constantes.OK_REQUEST;
            }
        } else {
            hastagsRepository.save(hash);
            return Constantes.OK_REQUEST;
        }
    }

    @Override
    @Transactional
    public String saveLogs(Logs logs) {

        AwlogLogger logger = new AwlogLogger();
        logger.setCreationDate(new Date());
        logger.setDetails(logs.getDetails());
        logger.setHost(logs.getHost());
        if (logs.getId() != null) {
            logger.setId(BigDecimal.valueOf(logs.getId()));
        }
        logger.setOrigin(logs.getOrigin());
        logger.setStacktrace(logs.getStacktrace());

        awtoLogRepository.save(logger);

        logs.getHashtags().stream().map(htg -> {
            AwlogHashtag hash = new AwlogHashtag();
            hash.setDescription(htg);
            return hash;
        }).map(hash -> {
            hastagsRepository.save(hash);
            return hash;
        }).map(hash -> {
            AwlogLoggerHashtag lh = new AwlogLoggerHashtag();
            lh.setLogId(logger);
            lh.setHastagId(hash);
            return lh;
        }).forEachOrdered(lh -> {
            hastagsRepository.save(lh);
        });

        return Constantes.OK_REQUEST;
    }

    @Override
    public List<Logs> findByAll() {
        List<AwlogLogger> lista = awtoLogRepository.findByAll();
        List<Logs> lst = new ArrayList<>();
        lista.stream().map(log -> {
            Logs dto = new Logs();
            BeanUtils.copyProperties(log, dto);
            return dto;
        }).forEachOrdered(dto -> {
            lst.add(dto);
        });
        return lst;
    }
}
