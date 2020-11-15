/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.dto;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fseguel
 */
public class Logs extends BaseBean {
    
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String host;
    @Setter
    @Getter
    private String origin;
    @Setter
    @Getter
    private String details;
    @Setter
    @Getter
    private String stacktrace;
    @Setter
    @Getter
    private List<Hashtags> hashtags;

    public Logs() {
        hashtags = new ArrayList<>();
    }
    
}
