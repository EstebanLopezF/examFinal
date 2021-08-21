package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.domain.Condomino;
import com.cenfotec.app.repo.CondominoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondominoServiceImpl implements CondominoService {

    @Autowired
    CondominoRepository repo;

    public Condomino getById(long id){
        return repo.getById(id);
    }

    public List<Condomino> getByCondominio(long id){
        return repo.getByCondominio(id);
    }
    
    public void create(Condomino condomino){
        repo.create(condomino.getNombre(), condomino.getIdCondominio() );
    }
        
    public boolean update(Condomino condomino){
    	
    	Condomino condominotty = repo.getById(condomino.getId());
    	
    	if (condominotty != null && condominotty.getEstado().equals(new String("activo")) ){
    	
    		try {
    			repo.update(condomino.getId(), condomino.getIdCondominio(), condomino.getNombre() );
    			return true;
    		} catch (Exception e) {
    			//Failed to get the Condomino by id or to update the Condomino.
    			return false;
    		}
    	}
    	return false;       
    }
    
    public void disable(long id) {
    	repo.disable(id);
    }
    
}

