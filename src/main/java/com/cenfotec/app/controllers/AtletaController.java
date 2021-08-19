package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.services.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
public class AtletaController {

    @Autowired
    AtletaService atletaService;
       
    @GetMapping("/atleta")
    List getAll(){
        return atletaService.getAll();
    }
    
    @GetMapping(path = {"/atleta/{id}"})
    ResponseEntity<Atleta> findById(@PathVariable long id){
        Optional<Atleta> result = atletaService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
    @GetMapping(path = {"/atleta/search/{name}"})							//activo, inactivo.
    ResponseEntity<List<Atleta>> getList(@PathVariable("name") String name){
        List<Atleta> atletas = atletaService.getSearch(name);
        return new ResponseEntity(atletas, HttpStatus.OK);
    }
    	
    @PostMapping("/atleta")
    public ResponseEntity<?> create(@RequestBody Atleta atleta){
    	atletaService.save(atleta);
        return new ResponseEntity("atleta creado", HttpStatus.OK);
    }
    
    @PutMapping("/atleta")												//un put recibe todo.
    public ResponseEntity<?> update(@RequestBody Atleta atleta){
    	atletaService.updateProcedure(atleta);
        return new ResponseEntity("atleta actualizado", HttpStatus.OK);
    }
    
    

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    @RequestMapping("/detalleAtleta/{id}")
    public String verId(Model model, @PathVariable long id) {
    model.addAttribute("atleta", atletaService.getById(id));
    return "detalleAtleta";
    }
    
    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertar";
    }
    
    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String save(Atleta atleta, BindingResult result, Model model) {
    	atletaService.save(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
        return "index";
    }
    
    @RequestMapping("/search/{name}")
    public String search(Model model, @PathVariable("name") String name) {
    	model.addAttribute("search", atletaService.getSearch(name));
    	return "listar";
    }
    
    @RequestMapping(value = "/update",  method = RequestMethod.GET)
    public String update(Atleta atleta, BindingResult result, Model model) {
    	atletaService.updateProcedure(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
    	return "index";
    }
    
    @RequestMapping( value="/update/{id}", method = RequestMethod.PUT)
    public String update(Atleta atleta, BindingResult result, Model model, @PathVariable String id) {
    	atletaService.updateProcedure(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
    	return "index";
    }*/
    
}



