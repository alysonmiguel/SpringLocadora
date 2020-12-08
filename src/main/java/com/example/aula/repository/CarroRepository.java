package com.example.aula.repository;

import com.example.aula.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
//    List<Carro> findByAnoFabricacao(Integer ano);
}
