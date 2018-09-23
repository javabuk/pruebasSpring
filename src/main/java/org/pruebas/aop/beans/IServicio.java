package org.pruebas.aop.beans;

import org.pruebas.aop.entity.FiltroBusqueda;

/***
 * Interface de prueba
 */
public interface IServicio {
	/***
	 * Metodo que devuelve el mensaje HL7
	 * @return
	 */
	String getMensajeHL7();

	/***
	 * Método de la operación
	 * @param parametro1
	 * @param parametro2
	 */
	void ejecutarOperacion(String parametro1, String parametro2);

	void pruebaParametros(FiltroBusqueda filtro);

}