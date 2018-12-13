package org.pruebas.aop;

import org.pruebas.aop.beans.IServicio;
import org.pruebas.aop.config.Configuracion;
import org.pruebas.aop.exception.ExecpcionPrueba;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Principal {

    public static void main(String[] args) {
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Configuracion.class);

	System.out.println("Prueba con Git");

	/*
	 * IServicio servicio = appContext.getBean("servicioPrueba",
	 * IServicio.class); servicio.ejecutarOperacion("uno", "dos");
	 * servicio.ejecutarOperacion("TEXTO PARAMETRO 1", "TEXTO PARAMETRO2");
	 * servicio.pruebaParametros(new FiltroBusqueda("1", "3"));
	 */

	IServicio servicio = appContext.getBean("servicioPruebaExcepciones", IServicio.class);
	/*
	 * try { servicio.ejecutarOperacion(null, null); } catch (Exception e) {
	 * if (e instanceof ExecpcionPrueba) { ExecpcionPrueba ex =
	 * (ExecpcionPrueba) e; System.out.println("ExcepcionPrueba, tipo: " +
	 * ex.getCodigo()); } }
	 */
	try {
	    servicio.pruebaParametros(null);
	} catch (Exception e) {
	    if (e instanceof ExecpcionPrueba) {
		ExecpcionPrueba ex = (ExecpcionPrueba) e;
		System.out.println("ExcepcionPrueba, tipo: " + ex.getCodigo());
	    }
	}

    }

}
