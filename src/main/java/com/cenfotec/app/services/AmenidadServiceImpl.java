package com.cenfotec.app.services;

import com.cenfotec.app.domain.Amenidad;
import com.cenfotec.app.repo.AmenidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AmenidadServiceImpl implements AmenidadService {

    @Autowired
    AmenidadRepository repo;



    public List<Amenidad> getByCondominio(long id){
        return repo.getByCondominio(id);
    }
    
    public boolean create(Amenidad amenidad){
    	try {
        repo.create(amenidad.getAmenidad(), amenidad.getIdCondominio());
        return true;
    	} catch (Exception e) {
    		//failed to add Amenidad
    		return false;
    	}
    }
    
}

