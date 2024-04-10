package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.ComissaoRequest;
import br.com.fateb.InformaticaAPI.dto.request.UsuarioRequest;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;

    @Autowired
    public void UsuarioService(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um Usuario com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getByCpf(@PathVariable("id") Integer id) {
        Usuario usuario = service.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Retorna todos os usuarios")
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        List<Usuario> usuarios = service.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Cadastra um Usuario")
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioRequest request) {
        Usuario usuario = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }


}
