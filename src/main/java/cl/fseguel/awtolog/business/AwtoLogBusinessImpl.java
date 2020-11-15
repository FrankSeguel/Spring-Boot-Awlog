/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.business;

import org.springframework.stereotype.Service;
import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.model.dao.AwtoLogDAO;
import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.entity.AwlogLogger;
import cl.fseguel.awtolog.model.entity.AwlogLoggerHashtag;
import cl.fseguel.awtolog.model.util.Constantes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogBusinessImpl implements AwtoLogBusiness {

    private static final Logger logger = LoggerFactory.getLogger(AwtoLogBusinessImpl.class);

    @Autowired
    private AwtoLogDAO awtoLogDAO;

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
        hash.setId(hastags.getId());
        hash.setDescription(hastags.getDescripcion());

        List<AwlogHashtag> lista = awtoLogDAO.findByDescription(hastags.getDescripcion());
        if (CollectionUtils.isNotEmpty(lista)) {
            if (lista.size() > 1) {
                return Constantes.BAD_REQUEST;
            } else {
                awtoLogDAO.saveAwlogHashtag(hash);
                return Constantes.OK_REQUEST;
            }
        } else {
            awtoLogDAO.saveAwlogHashtag(hash);
            return Constantes.OK_REQUEST;
        }
    }

    @Override
    @Transactional
    public String saveLogs(Logs logs) {

        AwlogLogger awlogLogger = new AwlogLogger();
        awlogLogger.setCreationDate(new Date());
        awlogLogger.setDetails(logs.getDetails());
        awlogLogger.setHost(logs.getHost());
        if (logs.getId() != null) {
            awlogLogger.setId(logs.getId());
        }
        awlogLogger.setOrigin(logs.getOrigin());
        awlogLogger.setStacktrace(logs.getStacktrace());

        awtoLogDAO.saveAwlogLogger(awlogLogger);

        logs.getHashtags().stream().map(htg -> {
            AwlogHashtag awlogHashtag = new AwlogHashtag();
            awlogHashtag.setDescription(htg);
            return awlogHashtag;
        }).map(awlogHashtag -> {
            //Verificamos si el Hashtags existe en la base de datos
            List<AwlogHashtag> lista = awtoLogDAO.findByDescription(awlogHashtag.getDescription());
            if (!CollectionUtils.isEmpty(lista) && lista.size()>0) {
                //El AwlogHashtag Existe y lo recuperamos
                awlogHashtag = lista.get(0);
            } else {
                //El AwlogHashtag no Existe y lo grabamos
                awtoLogDAO.saveAwlogHashtag(awlogHashtag);
            }
            return awlogHashtag;
        }).map(hash -> {
            AwlogLoggerHashtag awlogLoggerHashtag = new AwlogLoggerHashtag();
            awlogLoggerHashtag.setLogId(awlogLogger);
            awlogLoggerHashtag.setHastagId(hash);
            return awlogLoggerHashtag;
        }).forEachOrdered(awlogLoggerHashtag -> {
            //Grabamos la relacion del log y el Hashtags
            awtoLogDAO.saveAwlogLoggerHashtag(awlogLoggerHashtag);
        });

        return Constantes.OK_REQUEST;
    }

    @Override
    public List<Logs> findByAll() {
        List<AwlogLogger> lista = awtoLogDAO.findByAllAwlogLogger();
        List<Logs> lst = new ArrayList<>();
        lista.stream().map(log -> {
            Logs dto = new Logs();
            BeanUtils.copyProperties(log, dto);
            dto.setId(log.getId());
            for (AwlogLoggerHashtag ht : log.getAwlogLoggerHashtagList()) {
                dto.getHashtags().add(ht.getHastagId().getDescription());
            }
            return dto;
        }).forEachOrdered(dto -> {
            lst.add(dto);
        });
        return lst;
    }

    @Override
    public List<Logs> findByAllHashtag(String hashtag) {
        List<AwlogLogger> lista = awtoLogDAO.findByAllAwlogLogger(hashtag);
        List<Logs> lst = new ArrayList<>();
        lista.stream().map(log -> {
            Logs dto = new Logs();
            BeanUtils.copyProperties(log, dto);
            dto.setId(log.getId());
            for (AwlogLoggerHashtag ht : log.getAwlogLoggerHashtagList()) {
                dto.getHashtags().add(ht.getHastagId().getDescription());
            }
            return dto;
        }).forEachOrdered(dto -> {
            lst.add(dto);
        });
        return lst;
    }

    @Override
    public Logs findByLogId(Integer logId) {
        AwlogLogger awlogLogger = awtoLogDAO.findAwlogLoggerByLogId(logId);
        Logs logs = new Logs();
        BeanUtils.copyProperties(awlogLogger, logs);
        logs.setId(awlogLogger.getId());
        for (AwlogLoggerHashtag ht : awlogLogger.getAwlogLoggerHashtagList()) {
            logs.getHashtags().add(ht.getHastagId().getDescription());
        }
        return logs;
    }
}
