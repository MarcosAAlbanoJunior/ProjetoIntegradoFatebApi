package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.service.CidadeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

//    private CidadeService service;
//
//    @Autowired
//    public void CidadeService(CidadeService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "Retorna uma Cidade com o iD informado")
//    @GetMapping("/{id}")
//    public ResponseEntity<Cidade> getByCpf(@PathVariable("id") Integer id) {
//        Cidade cliente = service.getCidadeById(id);
//        return ResponseEntity.ok(cliente);
//    }
//
//    @Operation(summary = "Retorna todos as cidades")
//    @GetMapping
//    public ResponseEntity<List<Cidade>> getCidades() {
//        List<Cidade> cidades = service.getAllCidades();
//        return ResponseEntity.ok(cidades);
//    }
//
//    @Operation(summary = "Cadastra uma Cidade")
//    @PostMapping
//    public ResponseEntity<Cidade> cadastrarCliente(@RequestBody Cidade request) {
//        Cidade cidade = service.cadastrar(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
//    }

}
