/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.utils.aop.monitorizacion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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

    @Around("execution(* cl.fseguel.awtolog.rest.controller.*.*(..))")
    public Object calculoTiempo(ProceedingJoinPoint joinPoint) throws Throwable {

        long t1 = System.currentTimeMillis();
        Object resultado = joinPoint.proceed();
        long t2 = System.currentTimeMillis();

        if (t2 - t1 > 2000) {
            System.out.println("Metodo lento:" + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + ":" + (t2 - t1));
        }

        return resultado;
    }
}
