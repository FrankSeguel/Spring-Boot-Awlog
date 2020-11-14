/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awlog.rest.controller;

import cl.fseguel.awlog.model.message.LogRequestMessage;
import cl.fseguel.awlog.model.message.LogResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fseguel
 */
@RestController
@RequestMapping(value = "/awlog")
public class AwLogController {
    
    private static final Logger logger = LoggerFactory.getLogger(AwLogController.class);
    
    /**
     * 
     *
     * @param request Peticion.
     * @return
     */
    @ApiOperation(value = "logs", response = LogResponseMessage.class,
            code = 200, notes = "Servicio REST/JSON que mapea contra la operación sujetos del servicio SOAP de UtilsController.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listado de parametros obtenidos con éxito"),
        @ApiResponse(code = 401, message = "Error en la autorización para consultar el recurso."),
        @ApiResponse(code = 403, message = "Acceso no permitido para consultar el recurso"),
        @ApiResponse(code = 404, message = "Recurso no encontrado")})
    @PostMapping(value = "/logs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LogResponseMessage logs(@RequestBody final LogRequestMessage request, HttpServletResponse res) {
        
        return null;
    }
    
}
