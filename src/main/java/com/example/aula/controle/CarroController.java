package com.example.aula.controle;

import com.example.aula.model.Carro;
import com.example.aula.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/carro")
public class CarroController {

    private CarroService service;

    @Autowired
    public void setService(CarroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carro> listAll () {
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Carro> getOne(@PathVariable Long id) {
        Optional<Carro> carro = service.findyById(id);
        if(carro.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Carro record =  carro.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public ResponseEntity<Carro> insert(@RequestBody Carro carro) {

        service.saveAndFlush(carro);

        return ResponseEntity.status(201).build();
//        return ResponseEntity.ok().build();
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro c) {
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
