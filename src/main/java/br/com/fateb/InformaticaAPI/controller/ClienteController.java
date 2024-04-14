package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService service;

    @Autowired
    public void ClienteService(ClienteService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um Cliente com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByCpf(@PathVariable("id") Integer id) {
        Cliente cliente = service.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = service.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Cadastra um Cliente")
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente request) {
        Cliente cliente = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Operation(summary = "Atualizar um Cliente")
    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente request) {
        service.atualizarEntidade(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
