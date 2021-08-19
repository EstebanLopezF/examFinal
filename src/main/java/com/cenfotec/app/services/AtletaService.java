package com.cenfotec.app.services;

import com.cenfotec.app.domain.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaService {

    public List<Atleta> getAll();
    public Optional<Atleta> findById(long id);
    public List<Atleta> getSearch(String nombre);
    public void save(Atleta atleta);
    public void updateProcedure(Atleta atleta);
    
}
