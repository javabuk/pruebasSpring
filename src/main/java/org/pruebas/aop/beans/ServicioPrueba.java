package org.pruebas.aop.beans;

import org.pruebas.aop.annot.IntegracionHL7;
import org.pruebas.aop.annot.ValidacionCampoUno;
import org.springframework.stereotype.Component;

@Component
public class ServicioPrueba implements IServicio {

	private String parametrosConcatenados;

	public String getMensajeHL7() {
		// TODO Auto-generated method stub
		return null;
	}

	@IntegracionHL7(metodoGeneracionMensajeHL7="generoMensaje")
	public void ejecutarOperacion(@ValidacionCampoUno String parametro1, String parametro2) {
		System.out.println("Dentro del metodo ejecutarOperacion");
		parametrosConcatenados = parametro1 + "-" + parametro2;
 	}
	
	public String generoMensaje() {
		System.out.println("Estoy generando el mensaje" + parametrosConcatenados);
		return "mensaje";
	}
	
}
