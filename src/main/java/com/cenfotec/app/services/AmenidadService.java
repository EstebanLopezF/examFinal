package com.cenfotec.app.services;

import com.cenfotec.app.domain.Amenidad;
import java.util.List;

public interface AmenidadService {


    public List<Amenidad> getByCondominio(long id);

    
}
