package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condominio;
import java.util.List;
import java.util.Optional;

public interface CondominioService {

    public List<Condominio> getAll();
    public Condominio getById(long id);
    public List<Condominio> getByStatus(String status);
    public boolean create(Condominio condominio);
    public boolean update(Condominio condominio);
    public boolean disable(long id);
    
}
