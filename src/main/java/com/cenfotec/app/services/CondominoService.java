package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condomino;
import java.util.List;
import java.util.Optional;

public interface CondominoService {

    public Condomino getById(long id);
    public void create(Condomino condomino);
    public List<Condomino> getByCondominio(long id);
    public boolean update(Condomino condomino);
    public void disable(long id);
    
}
