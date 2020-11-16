/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.utils.aop.monitorizacion;

import cl.fseguel.awtolog.business.AwtoLogBusiness;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.model.util.Constantes;
/**
 *
 * @author fseguel
 * @see Siempre que creemos una aplicacion debieramos tener informacion de
 * estadisticas de rendimiento
 * https://www.arquitecturajava.com/spring-boot-aop-y-rendimiento/
 *
 */
@Aspect
@Component
public class AspectoPerformance {

    @Autowired
    private AwtoLogBusiness awtoLogBusiness;

    @Around("execution(* cl.fseguel.awtolog.rest.controller.*.*(..))")
    public Object calculoTiempo(ProceedingJoinPoint joinPoint) throws Throwable {

        long t1 = System.currentTimeMillis();
        Object resultado = joinPoint.proceed();
        long t2 = System.currentTimeMillis();
        // Toda Peticion que demore mas de 2000 Segunndos se registra en la base de datos de log
        // La idea ya que al ser una aplicacion enfocada al registro de log. Sea la misma aplicacion que registre su propia informacion.
        if (t2 - t1 > 2000) {
            Logs logs = new Logs();
            logs.getHashtags().add(Constantes.HASHTAGS_PERFORMANCE);
            logs.setOrigin(Constantes.ORIGEN_AWTOLOGS);
            logs.setDetails( String.valueOf(t2 - t1) );
            logs.setHost(Constantes.HOST_AWTOLOGS);
            logs.setStacktrace( "Tiempo de Respuesta Metodo :" + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + ":" + (t2 - t1) );
            awtoLogBusiness.saveLogs(logs);
        }

        return resultado;
    }
}
