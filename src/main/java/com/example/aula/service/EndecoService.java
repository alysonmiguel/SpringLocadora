package com.example.aula.service;

import com.example.aula.model.Endereco;
import com.example.aula.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EndecoService {

    private EnderecoRepository repository;

    @Autowired
    public void setRepository(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco saveAndFlush(Endereco endereco) {
        return repository.saveAndFlush(endereco);
    }

    public Endereco getById(Long id) {
        return repository.getOne(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Endereco> findyById(Long id) {
        return repository.findById(id);
    }


}
