package com.example.aula.service;

import com.example.aula.model.Categoria;
import com.example.aula.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    @Autowired
    public void setRepository(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria saveAndFlush(Categoria categoria) {
        return repository.saveAndFlush(categoria);
    }

    public Categoria getById(Long id) {
        return repository.getOne(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Categoria> findyById(Long id) {
        return repository.findById(id);
    }



}
