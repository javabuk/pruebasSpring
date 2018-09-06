package org.pruebas.aop.aspects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.pruebas.aop.annot.EnvioHL7;
import org.pruebas.aop.annot.IntegracionHL7;
import org.pruebas.aop.beans.IServicio;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class IntegracionHL7Aspect {
	
	//@Around("@annotation(org.pruebas.aop.annot.IntegracionHL7)")
	public Object negocioAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		//System.out.println("Before invoking ejecutarOperacion() method");
		Object value = null;
		IServicio servicio =  null;
		try {
			
			value = proceedingJoinPoint.proceed();
			
			Object objeto = proceedingJoinPoint.getTarget();
			Class<? extends Object> class1 = objeto.getClass();
			
			
			
			Method[] declaredMethods = class1.getDeclaredMethods();
			String metodoGeneracionMensaje = "";
			for (int i = 0; i < declaredMethods.length; i++) {
					//System.out.println(declaredMethods[i].getName());
					Annotation[] declaredAnnotations = declaredMethods[i].getDeclaredAnnotations();
					for (Annotation anot : declaredAnnotations) {
						IntegracionHL7 anotHL7 = (IntegracionHL7)anot;
						metodoGeneracionMensaje = anotHL7.metodoGeneracionMensajeHL7();
						//System.out.println(metodoGeneracionMensaje);
					}
					
			}
			final String filtroBusqueda = metodoGeneracionMensaje;
			//Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods).filter(p -> p.getName().equals(metodoGeneracionMensaje)).findFirst();
			Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods).filter( x -> filtroBusqueda.equals(x.getName())).findFirst();
			if (metodoMensajeHL7.isPresent()) {
				String mensajeDevuelto = (String)metodoMensajeHL7.get().invoke(objeto);
				System.out.println("Mensaje que se ha generado: " + mensajeDevuelto);
			}
			//servicio = (IServicio)proceedingJoinPoint.getTarget();
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//System.out.println("Envio del mensaje: " + servicio.getMensajeHL7());
		//System.out.println("After invoking ejecutarOperacion() method. Return value="+value);
		return value;
	}
	@Around("@annotation(anotacion)")
	public Object negocioAroundAdviceMejorado(ProceedingJoinPoint proceedingJoinPoint, IntegracionHL7 anotacion){
		System.out.println(anotacion.metodoGeneracionMensajeHL7());
		Object value = null;
		IServicio servicio =  null;
		try {
			
			value = proceedingJoinPoint.proceed();
			
			Object objeto = proceedingJoinPoint.getTarget();
			Class<? extends Object> class1 = objeto.getClass();
			
			
			Method[] declaredMethods = class1.getDeclaredMethods();
			
			final String filtroBusqueda = anotacion.metodoGeneracionMensajeHL7();
			//Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods).filter(p -> p.getName().equals(metodoGeneracionMensaje)).findFirst();
			Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods).filter( x -> filtroBusqueda.equals(x.getName())).findFirst();
			if (metodoMensajeHL7.isPresent()) {
				String mensajeDevuelto = (String)metodoMensajeHL7.get().invoke(objeto);
				System.out.println("Mensaje que se ha generado: " + mensajeDevuelto);
			}
			//servicio = (IServicio)proceedingJoinPoint.getTarget();
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//System.out.println("Envio del mensaje: " + servicio.getMensajeHL7());
		//System.out.println("After invoking ejecutarOperacion() method. Return value="+value);
		return value;
	}
	
//	@After( "negocioAroundAdviceMejorado()")
//	public void antes(IntegracionHL7 anotacion) {
//		System.out.println("Dentro del metodo antes");
//	}

}
