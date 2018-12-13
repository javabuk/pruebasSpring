package org.pruebas.aop.exception;

import org.pruebas.aop.enums.CodigosExcepcion;

public class ExecpcionPrueba extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7292508116672544089L;

    private CodigosExcepcion codigo;
    private String descripcion;

    public CodigosExcepcion getCodigo() {
	return codigo;
    }

    public void setCodigo(CodigosExcepcion codigo) {
	this.codigo = codigo;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public ExecpcionPrueba(CodigosExcepcion codigo, String descripcion) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
    }

}
