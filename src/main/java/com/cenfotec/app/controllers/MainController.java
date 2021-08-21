package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Amenidad;
import com.cenfotec.app.domain.Condominio;
import com.cenfotec.app.domain.Condomino;
import com.cenfotec.app.domain.Cuota;
import com.cenfotec.app.services.AmenidadService;
import com.cenfotec.app.services.CondominioService;
import com.cenfotec.app.services.CondominoService;
import com.cenfotec.app.services.CuotaService;

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
    
    @Autowired
    CuotaService cuotaService;
    
    @Autowired
    CondominoService condominoService;
       
  //------------------------------------------------------------------------------------------------------------Condominio:
    
    @GetMapping("/condominio")
    List getAll(){
        return condominioService.getAll();
    }
    
    @GetMapping(path = {"/condominio/{id}"})
    ResponseEntity<Condominio> findById(@PathVariable long id){
        Condominio result = condominioService.getById(id);
        if (result != null){
            return ResponseEntity.ok().body(result);
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
    	boolean response = condominioService.update(condominio);
    	if (response) {
    		return new ResponseEntity("condominio actualizado", HttpStatus.OK);
    	} else {
    		return new ResponseEntity("El condominio no se pudo actualizar", HttpStatus.UNAUTHORIZED);
    	}
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
    
    
    @PostMapping("/cuota")
    ResponseEntity<?> createCuota(@RequestBody Cuota cuota){
    	cuotaService.create(cuota);
        return new ResponseEntity("Cuota Historica creada", HttpStatus.OK);
    }
    
    @GetMapping(path = {"/cuota/cuotaXcondominio/{id}"})							
    ResponseEntity<List<Amenidad>> cuotaXcondominio(@PathVariable("id") long id){
        List<Cuota> amenidades = cuotaService.getByCondominio(id);
        return new ResponseEntity(amenidades, HttpStatus.OK);
    }
    
    
    //------------------------------------------------------------------------------------------------------------Condomino:
    
    @PostMapping("/condomino")
    ResponseEntity<?> createCondomino(@RequestBody Condomino condomino){
    	condominoService.create(condomino);
        return new ResponseEntity("condomino creado", HttpStatus.OK);
    }
    
    @GetMapping(path = {"/condomino/condominoXcondominio/{id}"})							
    ResponseEntity<List<Condomino>> condominoXcondominio(@PathVariable("id") long id){
        List<Condomino> condominos = condominoService.getByCondominio(id);
        return new ResponseEntity(condominos, HttpStatus.OK);
    }
    
    @PutMapping("/condomino/desactivar/{id}")
    public ResponseEntity<?> disableCondomino(@PathVariable("id") long id){
    	condominoService.disable(id);
        return new ResponseEntity("Condomino desabilitado", HttpStatus.OK);
    }
    
    @GetMapping(path = {"/condomino/{id}"})
    ResponseEntity<Condomino> findCondominoById(@PathVariable long id){
        Optional<Condomino> result = condominoService.getById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
    @PutMapping("/condomino")												
    ResponseEntity<?> updateCondomino(@RequestBody Condomino condomino){
    	condominoService.update(condomino);
        return new ResponseEntity("Condomino actualizado", HttpStatus.OK);
    }
    
    
    
        
}



