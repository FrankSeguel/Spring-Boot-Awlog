/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.dao;

import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.entity.AwlogLogger;
import cl.fseguel.awtolog.model.entity.AwlogLoggerHashtag;
import java.util.List;

/**
 *
 * @author fseguel
 */
public interface AwtoLogDAO {
    
    public List<AwlogHashtag> findByDescription(String descripcion);
    
    public AwlogLogger saveAwlogLogger(AwlogLogger logger);
    
    public AwlogHashtag saveAwlogHashtag(AwlogHashtag hashtag);
    
    public AwlogLoggerHashtag saveAwlogLoggerHashtag(AwlogLoggerHashtag awlogLoggerHashtag);
    
    public List<AwlogLogger> findByAllAwlogLogger();
    
    public List<AwlogLogger> findByAllAwlogLogger(String hashtag);
    
    public AwlogLogger findAwlogLoggerByLogId(Integer logId);
    
}
