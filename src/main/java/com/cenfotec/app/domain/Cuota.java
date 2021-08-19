package com.cenfotec.app.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Cuota {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private long idCondominio;
	private LocalDate fecha;
	private double precio;

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
        this.id = idCondominio;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
