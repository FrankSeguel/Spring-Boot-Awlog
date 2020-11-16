/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.api.message;

import cl.fseguel.awtolog.api.dto.Logs;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author fseguel
 * @ https://pastebin.com/GpA4rzZg
 */
public class LogsResponseMessage {
    @Setter
    @Getter
    private List<Logs> logs;
}