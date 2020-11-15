/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.service;

import cl.fseguel.awtolog.api.message.HastagsRequestMessage;
import cl.fseguel.awtolog.api.message.LogRequestMessage;

/**
 *
 * @author fseguel
 */
public interface AwtoLogService {
    
    public String saveHashtags(HastagsRequestMessage request);
    
    public String saveLogs(LogRequestMessage request);
    
}
