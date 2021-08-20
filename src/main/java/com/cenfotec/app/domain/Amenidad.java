package com.cenfotec.app.domain;

import javax.persistence.*;

@Entity
public class Amenidad {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private long idCondominio;
	private String amenidad;
		
	public Amenidad() {}
	
	public Amenidad(long id, long idCondominio, String amenidad) {
		this.id = id;
		this.idCondominio = idCondominio;
		this.amenidad = amenidad;
	}
	
	public Amenidad(long idCondominio, String amenidad) {
		this.idCondominio = idCondominio;
		this.amenidad = amenidad;
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
    
    public String getAmenidad() {
        return amenidad;
    }

    public void setFecha(String amenidad) {
        this.amenidad = amenidad;
    }
    
}
