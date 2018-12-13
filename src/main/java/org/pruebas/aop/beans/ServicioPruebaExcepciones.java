package org.pruebas.aop.beans;

import org.pruebas.aop.annot.GenerarException;
import org.pruebas.aop.entity.FiltroBusqueda;
import org.pruebas.aop.enums.CodigosExcepcion;
import org.springframework.stereotype.Component;

@Component
public class ServicioPruebaExcepciones implements IServicio {

    @Override
    public String getMensajeHL7() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    @GenerarException(codigo = CodigosExcepcion.CODIGO_EXCEPCION_UNO)
    public void ejecutarOperacion(String parametro1, String parametro2) {
	throw new RuntimeException("Prueba con CODIGO EXCEPCION UNO");

    }

    @Override
    @GenerarException
    public void pruebaParametros(FiltroBusqueda filtro) {
	throw new RuntimeException("Prueba sin especificar error");

    }

}
