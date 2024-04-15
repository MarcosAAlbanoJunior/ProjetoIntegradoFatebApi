package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.entity.Vendedor;
import br.com.fateb.InformaticaAPI.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private VendedorService service;


    @Autowired
    public void Vendedores(VendedorService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um Vendedor com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getByCpf(@PathVariable("id") Integer id) {
        Vendedor vendedor = service.getVendedorById(id);
        return ResponseEntity.ok(vendedor);
    }

    @Operation(summary = "Retorna todos os vendedors")
    @GetMapping
    public ResponseEntity<List<Vendedor>> getVendedor() {
        List<Vendedor> vendedors = service.getAllVendedors();
        return ResponseEntity.ok(vendedors);
    }

    @Operation(summary = "Cadastra um Vendedor")
    @PostMapping
    public ResponseEntity<Vendedor> cadastrarVendedor(@RequestBody Vendedor request) {
        Vendedor vendedor = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

    @Operation(summary = "Atualizar um Vendedor")
    @PutMapping
    public ResponseEntity<Vendedor> atualizarVendedor(@RequestBody Vendedor request) {
        Vendedor vendedor = service.atualizarVendedor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

}
