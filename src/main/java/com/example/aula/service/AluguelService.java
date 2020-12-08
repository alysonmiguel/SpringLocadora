package com.example.aula.service;

import com.example.aula.model.Aluguel;
import com.example.aula.model.Carro;
import com.example.aula.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private AluguelRepository repository;

    @Autowired
    public void setRepository(AluguelRepository repository) {
        this.repository = repository;
    }

    public List<Aluguel> findAll() {
        return repository.findAll();
    }

    public Aluguel save(Aluguel aluguel) {
        return repository.save(aluguel);
    }

    public Aluguel saveAndFlush(Aluguel aluguel) {
        return repository.saveAndFlush(aluguel);
    }

    public Aluguel getById(Long id) {
        return repository.getOne(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Aluguel> findyById(Long id) {
        return repository.findById(id);
    }



}
