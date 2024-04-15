package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.ClienteTelefone;
import br.com.fateb.InformaticaAPI.service.TelefoneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    private TelefoneService service;

    @Autowired
    public void TelefoneService(TelefoneService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um TelefonesCliente com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteTelefone> getByCpf(@PathVariable("id") Integer id) {
        ClienteTelefone telefone = service.getTelefoneById(id);
        return ResponseEntity.ok(telefone);
    }

    @Operation(summary = "Retorna todos os telefones")
    @GetMapping
    public ResponseEntity<List<ClienteTelefone>> getTelefones() {
        List<ClienteTelefone> telefones = service.getAllTelefones();
        return ResponseEntity.ok(telefones);
    }

    @Operation(summary = "Cadastra um TelefonesCliente")
    @PostMapping
    public ResponseEntity<?> cadastrarTelefones(@RequestBody ClienteTelefone request) {
        service.cadastrar(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar um Telefone Cliente")
    @PutMapping
    public ResponseEntity<ClienteTelefone> atualizarCliente(@RequestBody ClienteTelefone request) {
        service.atualizarTelefone(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
