package com.cenfotec.app.services;

import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.domain.Cuota;
import com.cenfotec.app.repo.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    CondominioRepository repo;
    
    @Autowired
    CuotaService cuotaService;

    @Override
    public List<Condominio> getAll() {
        return repo.listall();
    }
    
    public Condominio getById(long id){
        return repo.getById(id);
    }

    public List<Condominio> getByStatus(String status){
        return repo.getByStatus(status);
    }
    
    public boolean create(Condominio condominio){
    	try {
        repo.create(condominio.getCantidadUnidades(), condominio.getCedulaJuridica(), condominio.getDireccion(), condominio.getNombre(), 
        		condominio.getRepresentante(), condominio.getEstado(), condominio.getCuota());
		} catch (Exception e) {
			//Failed to create Condominio.
			return false;
		}
    	return true;
    }
        
    public boolean update(Condominio condominio){
    	   	
    	Condominio condominiotty = repo.getById(condominio.getId());
    	  	
    	if (condominiotty != null && condominiotty.getEstado().equals(new String("activo")) ){
    		
    		try {
            repo.update(condominio.getId(), condominio.getCantidadUnidades(), condominio.getCedulaJuridica(), condominio.getDireccion(), condominio.getNombre(), 
            		condominio.getRepresentante(), condominio.getCuota());
            
            if(condominio.getCuota() != condominiotty.getCuota()) {
            	Cuota cuota = new Cuota(condominio.getId(),condominiotty.getCuota());
            	cuotaService.create(cuota);
            }
            
            return true;
    		} catch (Exception e) {
    			//Failed to get the Condominio by id or to update the Condominio.
    			return false;
    		}
    	} 
    	return false;
    }
    
    public void disable(long id) {
    	repo.disable(id);
    }
    
}

