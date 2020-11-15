/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.service;

import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.business.AwtoLogBusiness;
import cl.fseguel.awtolog.model.util.Constantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogFacadeImpl implements AwtoLogFacade{
    
    @Autowired
    private AwtoLogBusiness awtoLogBusiness;
    
    @Override
    public String saveHashtags(Hastags hastags){
        
        if(hastags!=null && hastags.getDescripcion()==null){
            return Constantes.BAD_REQUEST_HASHTAGS_DES_REQ;
        }
        
        return awtoLogBusiness.saveHastags(hastags);
    }
    
    @Override
    public String saveLogs(Logs logs){
        return awtoLogBusiness.saveLogs(logs);
    }
    
    @Override
    public List<Logs> findByAll(){
        return awtoLogBusiness.findByAll();
    }
}
