package com.example.aula.service;

import com.example.aula.model.Carro;
import com.example.aula.model.Usuario;
import com.example.aula.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository repository;

    @Autowired
    public void setRepository(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public Carro saveAndFlush(Carro carro) {
        return repository.saveAndFlush(carro);
    }

    public Carro getById(Long id) {
        return repository.getOne(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Carro> findyById(Long id) {
        return repository.findById(id);
    }


}
