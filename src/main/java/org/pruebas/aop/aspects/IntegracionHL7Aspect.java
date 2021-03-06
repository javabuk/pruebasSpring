package org.pruebas.aop.aspects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.pruebas.aop.annot.GenerarException;
import org.pruebas.aop.annot.IntegracionHL7;
import org.pruebas.aop.beans.IServicio;
import org.pruebas.aop.exception.ExecpcionPrueba;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class IntegracionHL7Aspect {

    // @Around("@annotation(org.pruebas.aop.annot.IntegracionHL7)")
    public Object negocioAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
	// System.out.println("Before invoking ejecutarOperacion() method");
	Object value = null;
	IServicio servicio = null;
	try {

	    value = proceedingJoinPoint.proceed();

	    Object objeto = proceedingJoinPoint.getTarget();
	    Class<? extends Object> class1 = objeto.getClass();

	    Method[] declaredMethods = class1.getDeclaredMethods();
	    String metodoGeneracionMensaje = "";
	    for (int i = 0; i < declaredMethods.length; i++) {
		// System.out.println(declaredMethods[i].getName());
		Annotation[] declaredAnnotations = declaredMethods[i].getDeclaredAnnotations();
		for (Annotation anot : declaredAnnotations) {
		    IntegracionHL7 anotHL7 = (IntegracionHL7) anot;
		    metodoGeneracionMensaje = anotHL7.metodoGeneracionMensajeHL7();
		    // System.out.println(metodoGeneracionMensaje);
		}

	    }
	    final String filtroBusqueda = metodoGeneracionMensaje;
	    // Optional<Method> metodoMensajeHL7 =
	    // Arrays.stream(declaredMethods).filter(p ->
	    // p.getName().equals(metodoGeneracionMensaje)).findFirst();
	    Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods)
		    .filter(x -> filtroBusqueda.equals(x.getName())).findFirst();
	    if (metodoMensajeHL7.isPresent()) {
		String mensajeDevuelto = (String) metodoMensajeHL7.get().invoke(objeto);
		System.out.println("Mensaje que se ha generado: " + mensajeDevuelto);
	    }
	    // servicio = (IServicio)proceedingJoinPoint.getTarget();

	} catch (Throwable e) {
	    e.printStackTrace();
	}
	// System.out.println("Envio del mensaje: " + servicio.getMensajeHL7());
	// System.out.println("After invoking ejecutarOperacion() method. Return
	// value="+value);
	return value;
    }

    @Around("@annotation(anotacion)")
    public Object negocioAroundAdviceMejorado(ProceedingJoinPoint proceedingJoinPoint, IntegracionHL7 anotacion) {
	System.out.println(anotacion.metodoGeneracionMensajeHL7());
	Object value = null;
	IServicio servicio = null;
	try {

	    value = proceedingJoinPoint.proceed();

	    Object objeto = proceedingJoinPoint.getTarget();
	    Class<? extends Object> class1 = objeto.getClass();

	    Method[] declaredMethods = class1.getDeclaredMethods();

	    final String filtroBusqueda = anotacion.metodoGeneracionMensajeHL7();
	    // Optional<Method> metodoMensajeHL7 =
	    // Arrays.stream(declaredMethods).filter(p ->
	    // p.getName().equals(metodoGeneracionMensaje)).findFirst();
	    Optional<Method> metodoMensajeHL7 = Arrays.stream(declaredMethods)
		    .filter(x -> filtroBusqueda.equals(x.getName())).findFirst();
	    if (metodoMensajeHL7.isPresent()) {
		String mensajeDevuelto = (String) metodoMensajeHL7.get().invoke(objeto);
		System.out.println("Mensaje que se ha generado: " + mensajeDevuelto);
	    }
	    // servicio = (IServicio)proceedingJoinPoint.getTarget();

	} catch (Throwable e) {
	    e.printStackTrace();
	}
	// System.out.println("Envio del mensaje: " + servicio.getMensajeHL7());
	// System.out.println("After invoking ejecutarOperacion() method. Return
	// value="+value);
	return value;
    }

    @Around("@annotation(anotacion)")
    public Object negocioAroundAdviceExcepcion(ProceedingJoinPoint proceedingJoinPoint, GenerarException anotacion)
	    throws Throwable {
	Object value = null;
	try {
	    value = proceedingJoinPoint.proceed();
	} catch (Throwable e) {
	    if (e instanceof ExecpcionPrueba) {
		// Las excpeciones de tipo ExepcionPrueba no hace falta
		// tratarlas
		throw e;
	    } else {
		// El resto de las excepciones las encapsulamos en la clase de
		// excepcion generica
		ExecpcionPrueba excepion = new ExecpcionPrueba(anotacion.codigo(), e.getMessage());
		throw excepion;
	    }
	}
	return value;
    }
/*
    @Around("args(org.pruebas.aop.entity.FiltroBusqueda)")
    public Object negocioAroundAdviceMejorado(ProceedingJoinPoint proceedingJoinPoint) {
	System.out.println("Validamos parametros!!!!!");
	Object value = null;
	Object[] argumentos = null;
	try {
	    value = proceedingJoinPoint.proceed();
	    argumentos = proceedingJoinPoint.getArgs();
	} catch (Throwable e) {
	    e.printStackTrace();
	}
	return value;
    }
*/
    // @After( "negocioAroundAdviceMejorado()")
    // public void antes(IntegracionHL7 anotacion) {
    // System.out.println("Dentro del metodo antes");
    // }

}
