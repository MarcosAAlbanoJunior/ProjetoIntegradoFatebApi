package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.CategoriaRequest;
import br.com.fateb.InformaticaAPI.entity.Categoria;
import br.com.fateb.InformaticaAPI.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService service;

    @Autowired
    public void CategoriaService(CategoriaService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna uma Categoria com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Integer id) {
        Categoria categoria = service.getCategoriaById(id);
        return ResponseEntity.ok(categoria);
    }

    @Operation(summary = "Retorna todos as Categorias")
    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias() {
        List<Categoria> categorias = service.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    @Operation(summary = "Cadastra um Categoria")
    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody CategoriaRequest request) {
        Categoria categoria = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }
}
