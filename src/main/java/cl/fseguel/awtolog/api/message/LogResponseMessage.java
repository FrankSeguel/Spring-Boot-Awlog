/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.message;

import cl.fseguel.awtolog.api.dto.Logs;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author fseguel
 * @ https://pastebin.com/q7dt2Fj3
 */
public class LogResponseMessage {
    @Setter
    @Getter
    private Logs logs;
}