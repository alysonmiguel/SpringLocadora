package com.example.aula.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 3, max = 30, message = ApiMensagens.TAMANHO_ERRADO)
    @NotBlank(message = ApiMensagens.CAMPO_VAZIO)
    String modelo;

    @NotBlank(message = ApiMensagens.CAMPO_VAZIO)
    String cor;

    @Min(value = 1500, message = ApiMensagens.ANO_MINIMO)
    @Max(value = 2020, message = ApiMensagens.ANO_MAXIMO)
    @NotNull(message = ApiMensagens.CAMPO_VAZIO)
    Integer anoFabricacao;

    @Min(value = 2, message = ApiMensagens.QTDP_MINIMO)
    @NotNull(message = ApiMensagens.CAMPO_VAZIO)
    Integer qtdPortas;

    @Min(value = 2, message = ApiMensagens.QTDL_MINIMO)
    @NotNull(message = ApiMensagens.CAMPO_VAZIO)
    Integer qtdLugares;

    @ManyToMany()
    @JoinTable(
            name = "carro_categoria",
            joinColumns = @JoinColumn(name = "carro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    List<Categoria> tipos;


}
