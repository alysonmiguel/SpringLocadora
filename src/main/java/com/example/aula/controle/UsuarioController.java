package com.example.aula.controle;

import com.example.aula.model.Usuario;
import com.example.aula.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listAll () {
        return usuarioService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getOne(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findyById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Usuario record = usuario.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {

        usuarioService.saveAndFlush(usuario);

        return ResponseEntity.status(201).build();
//        return ResponseEntity.ok().build();
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario u) {
        return usuarioService.findyById(id).map( recerd -> {
            usuarioService.saveAndFlush(u);
            return ResponseEntity.ok().body(u);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return usuarioService.findyById(id).map(record ->{
            usuarioService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
