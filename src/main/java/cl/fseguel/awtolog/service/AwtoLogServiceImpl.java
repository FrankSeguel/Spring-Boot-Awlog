/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.service;

import cl.fseguel.awtolog.api.message.HastagsRequestMessage;
import org.springframework.stereotype.Service;
import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.message.LogRequestMessage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogServiceImpl implements AwtoLogService{

    @Autowired
    private AwtoLogFacade awtoLogFacade;
    
    @Override
    public String saveHashtags(HastagsRequestMessage request) {
        Hastags hastags = new Hastags();
        hastags.setId( request.getId() );
        hastags.setDescripcion( request.getDescripcion() );
        
        return awtoLogFacade.saveHashtags(hastags);
    }
    
    public String saveLogs(LogRequestMessage request){
        return null;
    }
    
}
