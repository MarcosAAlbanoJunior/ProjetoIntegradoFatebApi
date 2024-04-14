package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.service.TelefoneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

//    private TelefoneService service;
//
//    @Autowired
//    public void TelefoneService(TelefoneService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "Retorna um TelefonesCliente com o iD informado")
//    @GetMapping("/{id}")
//    public ResponseEntity<TelefonesPessoa> getByCpf(@PathVariable("id") Integer id) {
//        TelefonesPessoa telefone = service.getTelefoneById(id);
//        return ResponseEntity.ok(telefone);
//    }
//
//    @Operation(summary = "Retorna todos os telefones")
//    @GetMapping
//    public ResponseEntity<List<TelefonesPessoa>> getTelefones() {
//        List<TelefonesPessoa> telefones = service.getAllTelefones();
//        return ResponseEntity.ok(telefones);
//    }
//
//    @Operation(summary = "Cadastra um TelefonesCliente")
//    @PostMapping
//    public ResponseEntity<?> cadastrarTelefones(@RequestBody TelefoneRequest request) {
//        service.cadastrar(request);
//        return ResponseEntity.ok().build();
//    }

}
