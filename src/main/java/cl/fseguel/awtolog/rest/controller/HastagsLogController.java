/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.rest.controller;

import cl.fseguel.awtolog.api.message.LogResponseMessage;
import cl.fseguel.awtolog.service.AwtoLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.fseguel.awtolog.api.message.HastagsRequestMessage;
import cl.fseguel.awtolog.model.util.Constantes;
import org.apache.commons.collections4.Get;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author fseguel
 */
@RestController
@RequestMapping(value = "/hastags")
public class HastagsLogController {

    private static final Logger logger = LoggerFactory.getLogger(HastagsLogController.class);

    @Autowired
    private AwtoLogService awtoLogService;

    /**
     *
     *
     * @param request Peticion.
     * @see Get /logs Cuerpo de la petición: https://pastebin.com/q7dt2Fj3
     *
     */
    @ApiOperation(value = "hastags", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación log del servicio SOAP de AwtoLogController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 400, message = "Existe mas de un registro repetido hashtag."),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @PutMapping(value = "/{hastags}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void hastags(@RequestBody final HastagsRequestMessage request, HttpServletResponse res) {
        logger.info("HastagsLogController :: hastags :: Request({})", request);
        String response = awtoLogService.saveHashtags(request);
        if (Constantes.BAD_REQUEST.equals(response)) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        logger.info("HastagsLogController :: hastags :: Response({})", response, res);
    }

}
