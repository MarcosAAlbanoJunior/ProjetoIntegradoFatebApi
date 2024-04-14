package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoPedidoRequest;
import br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse;
import br.com.fateb.InformaticaAPI.entity.Pedido;
import br.com.fateb.InformaticaAPI.entity.Produto;
import br.com.fateb.InformaticaAPI.entity.ProdutoPedido;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.PedidoRepository;
import br.com.fateb.InformaticaAPI.repository.ProdutoPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoPedidoService {

    ProdutoPedidoRepository repository;

    ProdutoService produtoService;

    PedidoRepository pedidoRepository;

    EstoqueService estoqueService;

    MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Autowired
    public void ProdutosPedidoRepository(ProdutoPedidoRepository repository, ProdutoService produtoService,
                                         PedidoRepository pedidoRepository,  EstoqueService estoqueService,
                                         MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.repository = repository;
        this.produtoService = produtoService;
        this.pedidoRepository = pedidoRepository;
        this.estoqueService = estoqueService;
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;

    }

    @Transactional
    public ProdutoPedido cadastrar(Integer idPedido, ProdutoPedidoRequest request) {

        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new NotFoundException("Pedido não encontrada"));

        Produto produto = produtoService.getProdutoById(request.idProduto());

        if(estoqueService.getEstoqueByIdProduto(request.idProduto()).getQuantidade() < request.quantidade()){
            throw new RuntimeException("Quantidade Insuficiente no estoque");
        }

        ProdutoPedido produtosPedido = new ProdutoPedido();
        produtosPedido.setValorProdutoReal(produto.getPreco());
        produtosPedido.setValorProdutoDesconto(produto.getPreco());
        produtosPedido.setQuantidade(request.quantidade());
        produtosPedido.setIdProduto(produto);
        produtosPedido.setIdPedido(pedido);

        estoqueService.subtrairProduto(produtosPedido.getIdProduto().getId(), produtosPedido.getQuantidade());

        return  repository.saveAndFlush(produtosPedido);
    }

    public ProdutoPedido getProdutoPedidoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<ProdutoPedido> getAllProdutoPedido() {
        return repository.findAll();
    }

    public List<ProdutoPedido> getProdutoPedidoPeloIdPedido(Integer idPedido) {
        return repository.produtosDeUmPedido(idPedido);
    }

    public List<ProdutosMaisVendidosResponse> consultarProdutosMaisVendidos(){
        return repository.findProdutosMaisVendidos();
    }
}
