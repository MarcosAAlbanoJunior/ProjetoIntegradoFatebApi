package br.com.fateb.InformaticaAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedores")
public class FormaPagamentoController {

//    private FornecedorService service;
//
//    @Autowired
//    public void FornecedorService(FornecedorService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "Retorna um Fornecedor com o iD informado")
//    @GetMapping("/{id}")
//    public ResponseEntity<Fornecedor> getById(@PathVariable("id") Integer id) {
//        Fornecedor venda = service.getFornecedorById(id);
//        return ResponseEntity.ok(venda);
//    }
//
//    @Operation(summary = "Retorna todos os Fornecedors")
//    @GetMapping
//    public ResponseEntity<List<Fornecedor>> getFornecedors() {
//        List<Fornecedor> vendas = service.getAllFornecedores();
//        return ResponseEntity.ok(vendas);
//    }
//
//    @Operation(summary = "Cadastra um Fornecedor")
//    @PostMapping
//    public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody FornecedorRequest request) {
//        Fornecedor venda = service.cadastrar(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
//    }
}
