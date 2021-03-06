package org.pruebas.aop.beans;

import org.pruebas.aop.annot.EnvioHL7;
import org.pruebas.aop.entity.FiltroBusqueda;
import org.springframework.stereotype.Component;

@Component
public class ServicioDiferente implements IServicio {

	public String getMensajeHL7() {
		return "ADT^A04";
	}

	//@EnvioHL7( metodoGeneracionMensaje = "getMensajeHL7")
	public void ejecutarOperacion(String parametro1, String parametro2) {
		System.out.println("Ejecuto operacion en Servicio Diferente");
	}

	public void pruebaParametros(FiltroBusqueda filtro){
		System.out.println(filtro.getParametro1() + "-" + filtro.getParametro2());
	}

}
