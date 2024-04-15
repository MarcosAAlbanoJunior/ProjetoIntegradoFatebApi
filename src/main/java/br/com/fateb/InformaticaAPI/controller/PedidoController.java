package br.com.fateb.InformaticaAPI.controller;


import br.com.fateb.InformaticaAPI.dto.request.PedidoRequest;
import br.com.fateb.InformaticaAPI.dto.response.PedidoResponse;
import br.com.fateb.InformaticaAPI.entity.Pedido;
import br.com.fateb.InformaticaAPI.entity.ProdutoPedido;
import br.com.fateb.InformaticaAPI.service.PedidoService;
import br.com.fateb.InformaticaAPI.service.ProdutoPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    PedidoService service;

    ProdutoPedidoService produtoPedidoService;

    @Autowired
    public void PedidoService(PedidoService service, ProdutoPedidoService produtoPedidoService) {
        this.service = service;
        this.produtoPedidoService = produtoPedidoService;
    }

    @Operation(summary = "Retorna um Pedido com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Integer id) {
        Pedido venda = service.getPedidoById(id);
        return ResponseEntity.ok(venda);
    }

    @Operation(summary = "Retorna todos os Pedidos")
    @GetMapping
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> vendas = service.getAllPedidos();
        return ResponseEntity.ok(vendas);
    }

    @Operation(summary = "Cadastra um Pedido")
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody PedidoRequest request) {
        Pedido pedido = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @Operation(summary = "Retorna todos os Produtos de um Pedido")
    @GetMapping("/pedido-produtos/{id}")
    public ResponseEntity<List<ProdutoPedido>> getProdutosPedidoById(@PathVariable("id") Integer id) {
        List<ProdutoPedido> produtos = produtoPedidoService.getProdutoPedidoPeloIdPedido(id);
        return ResponseEntity.ok(produtos);
    }

}
