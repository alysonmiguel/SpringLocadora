package com.example.aula.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class  Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    @Size(min = 8, max = 8, message = ApiMensagens.TAMANHO_ERRADO)
    String cep;

    String cidade;

    String rua;

//    @OneToOne(mappedBy = "endereco", cascade = CascadeType.PERSIST)
//    Usuario usuario;

}
