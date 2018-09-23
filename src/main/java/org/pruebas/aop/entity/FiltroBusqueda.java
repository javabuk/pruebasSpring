package org.pruebas.aop.entity;

public class FiltroBusqueda {

    private String parametro1;

    private String parametro2;


    public FiltroBusqueda(String parametro1, String parametro2) {
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
    }


    public String getParametro2() {
        return parametro2;
    }

    public void setParametro2(String parametro2) {
        this.parametro2 = parametro2;
    }

    public String getParametro1() {
        return parametro1;
    }

    public void setParametro1(String parametro1) {
        this.parametro1 = parametro1;
    }
}
