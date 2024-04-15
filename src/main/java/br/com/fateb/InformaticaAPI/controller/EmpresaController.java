package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.EmpresaRequest;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private EmpresaService service;

    @Autowired
    public void EmpresaService(EmpresaService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna uma Empresa com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Integer id) {
        Empresa empresa = service.getEmpresaById(id);
        return ResponseEntity.ok(empresa);
    }

    @Operation(summary = "Retorna todos as Empresas")
    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresas() {
        List<Empresa> empresas = service.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @Operation(summary = "Cadastra um Empresa")
    @PostMapping
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa request) {
        Empresa empresa = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @Operation(summary = "Atualizar um Empresa")
    @PutMapping
    public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa request) {
        Empresa empresa = service.atualizarEmpresa(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

}
