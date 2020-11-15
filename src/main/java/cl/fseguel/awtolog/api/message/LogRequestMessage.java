/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.message;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
/**
 *
 * @author fseguel
 * @see POST /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
 */
public class LogRequestMessage extends BaseBean {

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
    private List<String> hashtags;

}
