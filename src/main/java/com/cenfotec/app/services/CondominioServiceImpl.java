package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.repo.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    CondominioRepository repo;

    @Override
    public List<Condominio> getAll() {
        return repo.listall();
    }
    
    public Optional<Condominio> getById(long id){
        return repo.getById(id);
    }

    public List<Condominio> getByStatus(String status){
        return repo.getByStatus(status);
    }
    
    public void create(Condominio condominio){
        repo.create(condominio.getCantidadUnidades(), condominio.getCedulaJuridica(), condominio.getDireccion(), condominio.getNombre(), 
        		condominio.getRepresentante(), condominio.getEstado(), condominio.getCuota());
    }
        
    public void update(Condominio condominio){
        repo.update(condominio.getId(), condominio.getCantidadUnidades(), condominio.getCedulaJuridica(), condominio.getDireccion(), condominio.getNombre(), 
        		condominio.getRepresentante(), condominio.getCuota());
    }
    
    public void disable(long id) {
    	repo.disable(id);
    }
    
}

