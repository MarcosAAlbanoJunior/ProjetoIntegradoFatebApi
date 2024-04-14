package br.com.fateb.InformaticaAPI.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

//    private VendaService service;
//
//    @Autowired
//    public void VendaService(VendaService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "Retorna um Venda com o iD informado")
//    @GetMapping("/{id}")
//    public ResponseEntity<Venda> getVendaById(@PathVariable("id") Integer id) {
//        Venda venda = service.getVendaById(id);
//        return ResponseEntity.ok(venda);
//    }
//
//    @Operation(summary = "Retorna todos os Vendas")
//    @GetMapping
//    public ResponseEntity<List<Venda>> getVendas() {
//        List<Venda> vendas = service.getAllVendas();
//        return ResponseEntity.ok(vendas);
//    }
//
//    @Operation(summary = "Cadastra um Venda")
//    @PostMapping
//    public ResponseEntity<VendaResponse> cadastrarVenda(@RequestBody VendaRequest request) {
//        VendaResponse vendaResponse = service.cadastrar(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(vendaResponse);
//    }
}
