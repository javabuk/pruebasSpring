package org.pruebas.aop.annot;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface EnvioHL7 {
	
	String metodoGeneracionMensaje() default "";

}
