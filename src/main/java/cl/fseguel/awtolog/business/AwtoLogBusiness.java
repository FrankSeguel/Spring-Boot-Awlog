/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.business;

import cl.fseguel.awtolog.api.dto.Hastags;
import cl.fseguel.awtolog.api.dto.Logs;
import java.util.List;

/**
 *
 * @author fseguel
 */
public interface AwtoLogBusiness {
    
    public String saveHastags(Hastags hastags);
    
    public String saveLogs(Logs logs);
    
    public List<Logs> findByAll();
    
    public List<Logs> findByAllHashtag(String hashtag);
    
}
