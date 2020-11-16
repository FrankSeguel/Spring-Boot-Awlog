/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.message;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
import lombok.Getter;
import lombok.Setter;
import cl.fseguel.awtolog.api.dto.Hastags;
/**
 *
 * @author fseguel
 * @see POST /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
 */
public class HastagsRequestMessage extends BaseBean {

    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String descripcion;

}
