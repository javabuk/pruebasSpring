package org.pruebas.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.pruebas.aop", "org.pruebas.aop.aspects"})
@EnableAspectJAutoProxy
public class Configuracion {

}
