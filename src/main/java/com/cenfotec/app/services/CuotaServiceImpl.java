package com.cenfotec.app.services;

import com.cenfotec.app.domain.Cuota;
import com.cenfotec.app.repo.CuotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuotaServiceImpl implements CuotaService {

    @Autowired
    CuotaRepository repo;

    public List<Cuota> getByCondominio(long id){
        return repo.getByCondominio(id);
    }
    
    public boolean create(Cuota cuota){
    	try {
        repo.create(cuota.getIdCondominio(), cuota.getPrecio());
        return true;
    	} catch(Exception e) {
    		//Failed to create historico de cuota;
    		return false;
    	}
    }
    
}

