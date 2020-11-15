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
 * @ https://pastebin.com/GpA4rzZg
 */
public class LogResponseMessage {
    @Setter
    @Getter
    private Logs logs;
}

/*
{
    "logs":[
        {
            "id": 1,
            "host": "http://host.com",
            "origin": "ms-api-admin",
            "details": "user_id 132453: no puede enviar comandos",
            "stacktrace": "...stacktrace...",
            "hashtags":[
                "#users", "#apiadmin", "#commands", "#nullpointer"
            ]
        },
        {
            "id": 2,
            "host": "http://host2.com",
            "origin": "ms-payment",
            "details": "Error al procesar pago",
            "stacktrace": "...stacktrace...",
            "hashtags":[
                "#payment", "#mspayment", "#error"
            ]
        }
    ]
}

*/