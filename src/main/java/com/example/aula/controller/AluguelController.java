package com.example.aula.controller;

import com.example.aula.model.Aluguel;
import com.example.aula.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/aluguel")
public class AluguelController {

    private AluguelService aluguelService;

    @Autowired
    public void setAluguelService(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public List<Aluguel> listAll () {
        return aluguelService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Aluguel> getOne(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelService.findyById(id);
        if(aluguel.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Aluguel record = aluguel.get();
            return ResponseEntity.ok().body(record);
        }
    }

    @PostMapping
    public Aluguel insert(@RequestBody Aluguel aluguel) {
         return   aluguelService.saveAndFlush(aluguel);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Aluguel> update(@PathVariable Long id, @RequestBody Aluguel a) {
        return aluguelService.findyById(id).map( recerd -> {
            aluguelService.saveAndFlush(a);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return aluguelService.findyById(id).map(record ->{
            aluguelService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
