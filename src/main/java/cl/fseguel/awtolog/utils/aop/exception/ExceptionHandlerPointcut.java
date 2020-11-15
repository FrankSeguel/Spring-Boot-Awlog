/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.utils.aop.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author fseguel
 */
@Configuration
@Aspect
public class ExceptionHandlerPointcut {
    
    @AfterThrowing(pointcut = "execution(* cl.fseguel.awtolog.rest.controller.*.*(..))", throwing = "ex")
    public void handleException(Exception ex) {
        // your common exception management code
        System.err.println(" ERROR : " + ex.getMessage());
    }
    
}
