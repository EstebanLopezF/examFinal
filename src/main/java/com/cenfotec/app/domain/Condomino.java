package com.cenfotec.app.domain;

import javax.persistence.*;

@Entity
public class Condomino {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private long idCondominio;
	private String nombre;
    private String estado;

    public Condomino() {}
    
    public Condomino(long id, long idCondominio, String nombre, String estado) {
    	this.id = id;
    	this.idCondominio = idCondominio;
    	this.nombre = nombre;
    	this.estado = estado;
    }    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(long idCondominio) {
        this.idCondominio = idCondominio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
