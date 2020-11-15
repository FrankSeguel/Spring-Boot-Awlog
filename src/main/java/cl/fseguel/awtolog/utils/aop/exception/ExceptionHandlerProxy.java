/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.utils.aop.exception;

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

    @Around("execution(* cl.fseguel.awtolog.rest.controller..*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            return joinPoint.proceed();
        } catch (BusinessException e) {
            //Es muy importante para las estadisticas las excpciones que se producen en la aplicacion.
            throw new BusinessException("Error Controlado");
        } catch (Exception e) {
            //Es muy importante para las estadisticas las excpciones que se producen en la aplicacion.
            throw new BusinessException("Error Controlado");
        }
//        Object resultado = null;
//        try {
//            resultado = joinPoint.proceed();
//        } catch (BusinessException ex) {
////            if (ex.getP_des_err() != null
////                    && (ex.getErrores() == null || ex.getErrores().size() < 1)) {
////                FacesUtils.error(ex.getP_des_err());
////            } else {
////                Iterator it = ex.getErrores().iterator();
////                while (it.hasNext()) {
////                    BusinessExceptionDetail error = (BusinessExceptionDetail) it.next();
////                    FacesUtils.error(error.getCampo() + " : " + error.getDescripcionError());
////                }
////            }
//        }
//        return resultado;
    }

}
