package com.cenfotec.app.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Condominio {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String direccion;
    private String cedulaJuridica;
    private String representante;
    private long cantidadUnidades;
    private String estado;
    private double cuota;

    public Condominio() {}
    
    public Condominio(long id, String nombre, String direccion, String cedulaJuridica, String representante, long cantidadUnidades, 
    		String estado, double cuota) {
    	
    	this.id = id;
    	this.nombre = nombre;
    	this.direccion = direccion;
    	this.cedulaJuridica = cedulaJuridica;
    	this.representante = representante;
    	this.cantidadUnidades = cantidadUnidades;
    	this.estado = estado;
    	this.cuota = cuota;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }
        
    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    public long getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(long cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    
}
