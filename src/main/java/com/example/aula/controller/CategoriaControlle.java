package com.example.aula.controller;

import com.example.aula.model.Categoria;
import com.example.aula.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/categoria")
public class CategoriaControlle {

    private CategoriaService service;

    @Autowired
    public void setService(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> listAll () {
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Categoria> getOne(@PathVariable Long id) {
        Optional<Categoria> categoria = service.findyById(id);
        if(categoria.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Categoria record =  categoria.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {

        return service.saveAndFlush(categoria);

//        return ResponseEntity.status(201).build();
//        return ResponseEntity.ok().build();
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria c) {
        return service.findyById(id).map( record -> {
            service.saveAndFlush(c);
            return ResponseEntity.ok().body(c);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return service.findyById(id).map(record ->{
            service.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }



}
