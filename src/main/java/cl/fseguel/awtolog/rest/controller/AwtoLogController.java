/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.rest.controller;

import cl.fseguel.awtolog.api.message.LogRequestMessage;
import cl.fseguel.awtolog.api.message.LogResponseMessage;
import cl.fseguel.awtolog.api.message.LogsResponseMessage;
import cl.fseguel.awtolog.model.util.Constantes;
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
import org.apache.commons.collections4.Get;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
        @ApiResponse(code = 400, message = "Existe mas de un registro repetido hashtag."),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void logsPost(@RequestBody final LogRequestMessage request, HttpServletResponse res) {
        String response = awtoLogService.saveLogs(request);
        if (Constantes.OK_REQUEST.equals(response)) {
            res.setStatus(HttpServletResponse.SC_OK);
        } else if (Constantes.BAD_REQUEST_HASHTAGS_DES_REQ.equals(response)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else if (Constantes.BAD_REQUEST.equals(response)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/HzvbZhjk
     *
     */
    @ApiOperation(value = "logs", response = LogsResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LogsResponseMessage logsGet() {
        LogsResponseMessage response = new LogsResponseMessage();
        response.setLogs(awtoLogService.findByAll());

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
    @GetMapping("/{hashtag}")
    @ResponseBody
    public LogsResponseMessage hashtagGet(@RequestParam final String request) {
        LogsResponseMessage response = new LogsResponseMessage();
        response.setLogs(awtoLogService.findByAllHashtag(request));
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
    @GetMapping("/{logId}")
    @ResponseBody
    public LogResponseMessage logsGetId(@PathVariable final Integer request) {
        LogResponseMessage response = new LogResponseMessage();
        response.setLogs( awtoLogService.findByLogId(request) );
        return response;
    }

}
