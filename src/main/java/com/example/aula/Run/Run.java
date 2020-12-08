package com.example.aula.Run;

import com.example.aula.model.Aluguel;
import com.example.aula.model.Carro;
import com.example.aula.model.Endereco;
import com.example.aula.model.Usuario;
import com.example.aula.repository.CarroRepository;
import com.example.aula.repository.EnderecoRepository;
import com.example.aula.repository.UsuarioRepository;
import com.example.aula.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Component
public class Run implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CarroRepository carroRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
/*   Usuario 1 1 Endereço
        Usuario u = new Usuario();
        Endereco e = new Endereco();

        e.setRua("pureza");

        u.setNome("Alyson ");
        u.setEndereco(e);

        e.setUsuario(u);

        enderecoRepository.save(e);
        usuarioRepository.save(u);
*/


/*  Usuario  N N Aluguel*/
        /*
        Usuario u = new Usuario();

        Aluguel a1 = new Aluguel();
        Aluguel a2 = new Aluguel();
        Aluguel a3 = new Aluguel();

        a1.setDataAluguel("data 1");
        a2.setDataAluguel("data 2");
        a3.setDataAluguel("data 3");

        List<Aluguel> alguel = new ArrayList<>();

        alguel.add(a1);
        alguel.add(a2);
        alguel.add(a3);

        u.setAlugueis(alguel);

        a1.setUsuario(u);
        a2.setUsuario(u);
        a3.setUsuario(u);

        usuarioRepository.save(u);
        */

        /* Carro 1 n Aluguel
        Carro c = new Carro();

        Aluguel a1 = new Aluguel();
        Aluguel a2 = new Aluguel();
        Aluguel a3 = new Aluguel();

        a1.setDataAluguel("c 1");
        a2.setDataAluguel("c 2");
        a3.setDataAluguel("c 3");

        List<Aluguel> alguel = new ArrayList<>();

        alguel.add(a1);
        alguel.add(a2);
        alguel.add(a3);

        c.setAluguel(alguel);

        a1.setCarro(c);
        a2.setCarro(c);
        a3.setCarro(c);

        carroRepository.save(c);


         */
/*  USUARIO N N CARRO
        Usuario u = new Usuario();
        Endereco e = new Endereco();

        e.setRua("pureza");

        u.setNome("Alyson ");
        u.setEndereco(e);

        e.setUsuario(u);

        enderecoRepository.save(e);

        Aluguel a1 = new Aluguel();
        Aluguel a2 = new Aluguel();
        Aluguel a3 = new Aluguel();

        a1.setDataAluguel("data 1");
        a2.setDataAluguel("data 2");
        a3.setDataAluguel("data 3");

        List<Aluguel> alguel = new ArrayList<>();

        alguel.add(a1);
        alguel.add(a2);
        alguel.add(a3);

        u.setAlugueis(alguel);

        a1.setUsuario(u);
        a2.setUsuario(u);
        a3.setUsuario(u);

        Carro c = new Carro();

        c.setModelo("gol");

        List<Carro> cs = new ArrayList<>();
        cs.add(c);

        u.setCarros(cs);


        usuarioRepository.save(u);*/
///        carroRepository.save(c);






    }
}
