/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.business;

import cl.fseguel.awtolog.model.repository.HastagsRepository;
import org.springframework.stereotype.Service;
import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.util.Constantes;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogBusinessImpl implements AwtoLogBusiness {

    @Autowired
    private HastagsRepository hastagsRepository;

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

}
