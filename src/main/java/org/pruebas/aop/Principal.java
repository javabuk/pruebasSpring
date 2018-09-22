package org.pruebas.aop;


import org.pruebas.aop.beans.IServicio;
import org.pruebas.aop.beans.Servicio;
import org.pruebas.aop.config.Configuracion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Configuracion.class);

		System.out.println("Es otro texto diferente");

		IServicio servicio = appContext.getBean("servicioPrueba", IServicio.class);
		servicio.ejecutarOperacion("uno", "dos");
		servicio.ejecutarOperacion("TEXTO PARAMETRO 1", "TEXTO PARAMETRO2");
		
	}

}
