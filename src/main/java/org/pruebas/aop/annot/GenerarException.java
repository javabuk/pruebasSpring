package org.pruebas.aop.annot;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.pruebas.aop.enums.CodigosExcepcion;

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface GenerarException {

    CodigosExcepcion codigo() default CodigosExcepcion.CODIGO_EXCEPCION_DOS;

}
