package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Amenidad;
import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.services.AmenidadService;
import com.cenfotec.app.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    CondominioService condominioService;
    
    @Autowired
    AmenidadService amenidadService;
       
  //------------------------------------------------------------------------------------------------------------Condominio:
    
    @GetMapping("/condominio")
    List getAll(){
        return condominioService.getAll();
    }
    
    @GetMapping(path = {"/condominio/{id}"})
    ResponseEntity<Condominio> findById(@PathVariable long id){
        Optional<Condominio> result = condominioService.getById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
    @GetMapping(path = {"/condominio/estado/{status}"})							
    ResponseEntity<List<Condominio>> listaEstado(@PathVariable("status") String status){
        List<Condominio> condominios = condominioService.getByStatus(status);
        return new ResponseEntity(condominios, HttpStatus.OK);
    }
    	
    @PostMapping("/condominio")
    ResponseEntity<?> create(@RequestBody Condominio condominio){
    	condominioService.create(condominio);
        return new ResponseEntity("condominio creado", HttpStatus.OK);
    }
    
    @PutMapping("/condominio")												
    ResponseEntity<?> update(@RequestBody Condominio condominio){
    	condominioService.update(condominio);
        return new ResponseEntity("condominio actualizado", HttpStatus.OK);
    }
    
   @PutMapping("/condominio/desactivar/{id}")
    public ResponseEntity<?> disable(@PathVariable("id") long id){
    	condominioService.disable(id);
        return new ResponseEntity("condominio actualizado", HttpStatus.OK);
    }

   //------------------------------------------------------------------------------------------------------------Amenidades:
   
    @GetMapping(path = {"/amenidad/amenidadXcondominio/{id}"})							
    ResponseEntity<List<Amenidad>> amenidadXcondominio(@PathVariable("id") long id){
        List<Amenidad> amenidades = amenidadService.getByCondominio(id);
        return new ResponseEntity(amenidades, HttpStatus.OK);
    }
    
    @PostMapping("/amenidad")
    ResponseEntity<?> createAmenidad(@RequestBody Amenidad amenidad){
    	amenidadService.create(amenidad);
        return new ResponseEntity("Amenidad creada", HttpStatus.OK);
    }
    
    //------------------------------------------------------------------------------------------------------------Cuota Historico:
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}



