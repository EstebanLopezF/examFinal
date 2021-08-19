package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condominio;
import java.util.List;
import java.util.Optional;

public interface CondominioService {

    public List<Condominio> getAll();
    public Optional<Condominio> getById(long id);
    public List<Condominio> getByStatus(String status);
    public void create(Condominio condominio);
    public void update(Condominio condominio);
    
}
