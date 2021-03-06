package com.example.aula.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String dataAluguel;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "carro_id")
    Carro carro;

}
