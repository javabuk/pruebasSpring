package org.pruebas.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class Servicio implements IServicio {
	
	/* (non-Javadoc)
	 * @see org.pruebas.aop.beans.IServicio#getMensajeHL7()
	 */
	public String getMensajeHL7() {
		return "ADT^A01";
	}

	/* (non-Javadoc)
	 * @see org.pruebas.aop.beans.IServicio#ejecutarOperacion()
	 */
	public void ejecutarOperacion(String parametro1, String parametro2) {
		System.out.println("Ejecutamos la operacion");
		
	}

}
