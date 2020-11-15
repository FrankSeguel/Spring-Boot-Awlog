/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.service;

import cl.fseguel.awtolog.api.message.HastagsRequestMessage;
import org.springframework.stereotype.Service;
import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.api.message.LogRequestMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fseguel
 */
@Service
public class AwtoLogServiceImpl implements AwtoLogService {

    @Autowired
    private AwtoLogFacade awtoLogFacade;

    @Override
    public String saveHashtags(HastagsRequestMessage request) {
        Hastags hastags = new Hastags();
        hastags.setId(request.getId());
        hastags.setDescripcion(request.getDescripcion());

        return awtoLogFacade.saveHashtags(hastags);
    }

    @Override
    public String saveLogs(LogRequestMessage request) {
        Logs logs = new Logs();
        logs.setDetails(request.getDetails());
        logs.setHashtags(request.getHashtags());
        logs.setHost(request.getHost());
        logs.setOrigin(request.getOrigin());
        logs.setStacktrace(request.getStacktrace());

        return awtoLogFacade.saveLogs(logs);
    }

    @Override
    public List<Logs> findByAll() {
        return awtoLogFacade.findByAll();
    }
    
    @Override
    public List<Logs> findByAllHashtag(String hashtag) {
        return awtoLogFacade.findByAllHashtag(hashtag);
    }

    @Override
    public Logs findByLogId(Integer logId) {
        return awtoLogFacade.findByLogId(logId);
    }
}
