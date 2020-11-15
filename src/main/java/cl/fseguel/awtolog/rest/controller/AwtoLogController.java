/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.rest.controller;

import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.api.message.LogRequestMessage;
import cl.fseguel.awtolog.api.message.LogResponseMessage;
import cl.fseguel.awtolog.api.message.LogsResponseMessage;
import cl.fseguel.awtolog.service.AwtoLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.fseguel.awtolog.api.message.HastagsRequestMessage;
import org.springframework.web.bind.annotation.PutMapping;
        
/**
 *
 * @author fseguel
 */
@RestController
@RequestMapping(value = "/logs")
public class AwtoLogController {

    private static final Logger logger = LoggerFactory.getLogger(AwtoLogController.class);

    @Autowired
    private AwtoLogService awtoLogService;

    /**
     *
     *
     * @param request Peticion.
     * @see POST /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
     *
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void logsPost(@RequestBody final LogRequestMessage request, HttpServletResponse res) throws Exception {
        
    }

    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
     *
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LogsResponseMessage logsGet(HttpServletResponse res) throws Exception {
        LogsResponseMessage response = new LogsResponseMessage();
        
        return response;
    }

    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
     *
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @GetMapping(value = "/{hashtag}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LogsResponseMessage hashtagGet(@RequestBody final String request, HttpServletResponse res) throws Exception {
        LogsResponseMessage response = new LogsResponseMessage();
        
        return response;
    }
    
    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/q7dt2Fj3
     *
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @GetMapping(value = "/{logId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LogResponseMessage logsGetId(@RequestBody final Integer request, HttpServletResponse res) throws Exception {
        LogResponseMessage response = new LogResponseMessage();
        response.setLogs(new Logs());
        return response;
    }
    
    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/q7dt2Fj3
     *
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @PutMapping(value = "/{hastags}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void hastags(@RequestBody final HastagsRequestMessage request, HttpServletResponse res) throws Exception {
        
    }
    
}
