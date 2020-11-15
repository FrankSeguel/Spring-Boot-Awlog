/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.utils.aop.exception;

import cl.fseguel.awtolog.api.dto.Logs;
import cl.fseguel.awtolog.business.AwtoLogBusiness;
import cl.fseguel.awtolog.model.util.Constantes;
import cl.fseguel.awtolog.utils.exception.BusinessException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fseguel
 * @see https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html
 * https://dzone.com/articles/handling-exceptions-using-springs-aop
 * https://dzone.com/articles/handling-exceptions-using-springs-aop
 * https://dzone.com/articles/java-exception-translation
 */
@Aspect
@Component
public class ExceptionHandlerProxy {

    @Autowired
    private AwtoLogBusiness awtoLogBusiness;

    @Around("execution(* cl.fseguel.awtolog.rest.controller..*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        Logs logs = new Logs();
        logs.getHashtags().add(Constantes.HASHTAGS_EXCEPTION);
        logs.setOrigin(Constantes.ORIGEN_AWTOLOGS);
        logs.setHost(Constantes.HOST_AWTOLOGS);
        
        try {
            return joinPoint.proceed();
        } catch (BusinessException e) {
            logs.setDetails( e.getMessage() );
            logs.setStacktrace( e.getStackTrace().toString() );
            awtoLogBusiness.saveLogs(logs);
            //Es muy importante para las estadisticas las excpciones que se producen en la aplicacion.
            throw new BusinessException("Error Controlado");
        } catch (Exception e) {
            logs.setDetails( e.getMessage() );
            logs.setStacktrace( e.getStackTrace().toString() );
            awtoLogBusiness.saveLogs(logs);
            //Es muy importante para las estadisticas las excpciones que se producen en la aplicacion.
            throw new BusinessException("Error Controlado");
        }

    }

}
