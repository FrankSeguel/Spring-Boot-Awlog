/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.dto;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fseguel
 */
public class Hashtags extends BaseBean{
    
    @Setter
    @Getter
    private String user;
    @Setter
    @Getter
    private String apiadmin;
    @Setter
    @Getter
    private String commands;
    @Setter
    @Getter
    private String nullpointer;
    
}
