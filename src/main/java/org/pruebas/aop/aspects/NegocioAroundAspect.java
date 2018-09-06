package org.pruebas.aop.aspects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pruebas.aop.annot.EnvioHL7;
import org.pruebas.aop.beans.IServicio;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class NegocioAroundAspect {

	//@Before("execution(public * ejecutar*())")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getName()");
	}
	
	//TODO: Que ocurre con los parámetros de los métodos, se puede hacer que no se tengan en cuenta a la hora de interceptar?
	
	//@Around("execution(* org.pruebas.aop.beans.IServicio.ejecutarOperacion())")
	@Around("@annotation(org.pruebas.aop.annot.EnvioHL7) && target(org.pruebas.aop.beans.IServicio)")
	//@annotation(org.pruebas.aop.annot.EnvioHL7)
	public Object negocioAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		//System.out.println("Before invoking ejecutarOperacion() method");
		Object value = null;
		IServicio servicio =  null;
		try {
			Object objeto = proceedingJoinPoint.getTarget();
			Class<? extends Object> class1 = objeto.getClass();
			
			
			
			Method[] declaredMethods = class1.getDeclaredMethods();
			for (int i = 0; i < declaredMethods.length; i++) {
					System.out.println(declaredMethods[i].getName());
					Annotation[] declaredAnnotations = declaredMethods[i].getDeclaredAnnotations();
					for (Annotation anot : declaredAnnotations) {
						EnvioHL7 anotHL7 = (EnvioHL7)anot;
						System.out.println(anotHL7.metodoGeneracionMensaje());
					}
					/*if( declaredMethods[i].isAnnotationPresent(EnvioHL7.class) ) {
						Annotation anotacion = declaredMethods[i].getAnnotation(EnvioHL7.class);
						EnvioHL7 anotacionHL7 = (EnvioHL7)anotacion;
						System.out.println("Configuacion de la anotacion " + anotacionHL7.metodoGeneracionMensaje());
					}*/
			}
			
			servicio = (IServicio)proceedingJoinPoint.getTarget();
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Envio del mensaje: " + servicio.getMensajeHL7());
		//System.out.println("After invoking ejecutarOperacion() method. Return value="+value);
		return value;
	}
	
}
