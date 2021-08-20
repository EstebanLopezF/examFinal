package com.cenfotec.app.services;

import com.cenfotec.app.domain.Cuota;

import java.util.List;

public interface CuotaService {

    public List<Cuota> getByCondominio(long id);
    public void create(Cuota cuota);
    
}
