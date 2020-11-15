/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.dao;

import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.entity.AwlogLogger;
import cl.fseguel.awtolog.model.entity.AwlogLoggerHashtag;
import cl.fseguel.awtolog.model.repository.AwtoLogRepository;
import cl.fseguel.awtolog.model.repository.HastagsRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fseguel
 */
@Component
public class AwtoLogDAOImpl implements AwtoLogDAO {

    private static final Logger logger = LoggerFactory.getLogger(AwtoLogDAOImpl.class);

    @Autowired
    private HastagsRepository hastagsRepository;
    @Autowired
    private AwtoLogRepository awtoLogRepository;
    
    @Override
    public List<AwlogHashtag> findByDescription(String descripcion){
        return hastagsRepository.findByDescription(descripcion);
    }
    
    @Override
    public AwlogLogger saveAwlogLogger(AwlogLogger awlogLogger){
        return awtoLogRepository.save(awlogLogger);
    }
    
    @Override
    public AwlogHashtag saveAwlogHashtag(AwlogHashtag awlogHashtag){
        return hastagsRepository.save(awlogHashtag);
    }
    
    @Override
    public AwlogLoggerHashtag saveAwlogLoggerHashtag(AwlogLoggerHashtag awlogLoggerHashtag){
        return hastagsRepository.save(awlogLoggerHashtag);
    }
    
    @Override
    public List<AwlogLogger> findByAllAwlogLogger(){
        return awtoLogRepository.findByAll();
    }
    
    @Override
    public List<AwlogLogger> findByAllAwlogLogger(String hashtag){
        return awtoLogRepository.findByAllHashtag(hashtag);
    }
    
    @Override
    public AwlogLogger findAwlogLoggerByLogId(Integer logId){
        return awtoLogRepository.findByLogId(logId);
    }
}
