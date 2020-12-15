package com.example.aula.controller;

import com.example.aula.model.Endereco;
import com.example.aula.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public List<Endereco> listAll(){
        return enderecoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {
        enderecoRepository.saveAndFlush(endereco);
        return ResponseEntity.status(201).build();
    }

}
