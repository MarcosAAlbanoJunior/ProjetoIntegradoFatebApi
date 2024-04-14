package br.com.fateb.InformaticaAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EstoqueController {

//    private EmpresaService service;
//
//    @Autowired
//    public void EmpresaService(EmpresaService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "Retorna uma Empresa com o iD informado")
//    @GetMapping("/{id}")
//    public ResponseEntity<Empresa> getById(@PathVariable("id") Integer id) {
//        Empresa empresa = service.getEmpresaById(id);
//        return ResponseEntity.ok(empresa);
//    }
//
//    @Operation(summary = "Retorna todos as Empresas")
//    @GetMapping
//    public ResponseEntity<List<Empresa>> getEmpresas() {
//        List<Empresa> empresas = service.getAllEmpresas();
//        return ResponseEntity.ok(empresas);
//    }
//
//    @Operation(summary = "Cadastra um Empresa")
//    @PostMapping
//    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody EmpresaRequest request) {
//        Empresa empresa = service.cadastrar(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
//    }
}
