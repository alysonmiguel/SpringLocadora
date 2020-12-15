package com.example.aula.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 3, max = 50, message = ApiMensagens.TAMANHO_ERRADO)
    @NotBlank(message = ApiMensagens.CAMPO_VAZIO)
    String nome;

    @Email()
    @NotBlank(message = ApiMensagens.CAMPO_VAZIO)
    String email;

    @Size(min = 8, message = ApiMensagens.ERRO_PASSWORD)
    String senha;

    String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "usuario_id")
//    List<Aluguel> alugueis;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "usuario_carro",
//            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "carro_id")
//    )
//    List<Carro> carros;


}
