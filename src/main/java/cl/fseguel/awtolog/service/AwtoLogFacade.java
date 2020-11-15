/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.service;

import cl.fseguel.awtolog.api.dto.Hastags;

/**
 *
 * @author fseguel
 */
public interface AwtoLogFacade {
    
    public String saveHashtags(Hastags hastags);
}
