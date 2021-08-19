package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
public class CondominioController {

    @Autowired
    CondominioService condominioService;
       
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
    
    @GetMapping(path = {"/condominio/search/{status}"})							//activo, inactivo.
    ResponseEntity<List<Condominio>> getList(@PathVariable("status") String status){
        List<Condominio> condominios = condominioService.getByStatus(status);
        return new ResponseEntity(condominios, HttpStatus.OK);
    }
    	
    @PostMapping("/condominio")
    public ResponseEntity<?> create(@RequestBody Condominio condominio){
    	condominioService.create(condominio);
        return new ResponseEntity("condominio creado", HttpStatus.OK);
    }
    
    @PutMapping("/condominio")												//un put recibe todo.
    public ResponseEntity<?> update(@RequestBody Condominio condominio){
    	condominioService.update(condominio);
        return new ResponseEntity("condominio actualizado", HttpStatus.OK);
    }
        
}



