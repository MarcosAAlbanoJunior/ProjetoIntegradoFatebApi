package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoVendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.entity.id.ProdutosVendaId;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ProdutoMapper;
import br.com.fateb.InformaticaAPI.mapper.ProdutoVendaMapper;
import br.com.fateb.InformaticaAPI.repository.ProdutosVendaRepository;
import br.com.fateb.InformaticaAPI.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoVendaService {

    private ProdutosVendaRepository repositoy;

    private ProdutoService produtoService;

    private VendaRepository vendaRepository;

    @Autowired
    public void ProdutosVendaRepository(ProdutosVendaRepository repositoy, ProdutoService produtoService, VendaRepository vendaRepository) {
        this.repositoy = repositoy;
        this.produtoService = produtoService;
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public ProdutosVenda cadastrar(Integer idVenda, ProdutoVendaRequest request) {

        Venda venda = vendaRepository.findById(idVenda).orElseThrow(() -> new NotFoundException("Venda não encontrada"));

        Produto produto = produtoService.getProdutoById(request.idProduto());

        if(produto.getQuantidadeEstoque() < request.quantidade()){
            throw new RuntimeException("Quantidade Insuficiente no estoque");
        }

        ProdutosVenda produtosVenda = ProdutoVendaMapper.INSTANCE.requestToEntity(request);
        produtosVenda.setPrecoUnitario(produto.getPreco());
        produtosVenda.setIdProduto(produto);
        produtosVenda.setIdVenda(venda);

        ProdutosVendaId produtosVendaId = new ProdutosVendaId();
        produtosVendaId.setIdProduto(produto.getId());
        produtosVendaId.setIdVenda(venda.getId());
        produtosVenda.setId(produtosVendaId);


        return  repositoy.saveAndFlush(produtosVenda);
    }

    public ProdutosVenda getProdutoVendaById(ProdutosVendaId id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<ProdutosVenda> getAllProdutosVenda() {
        return repositoy.findAll();
    }

    public List<ProdutosVenda> getProdutosVendaPeloIdVenda(Integer idVenda) {
        return repositoy.produtosDeUmaVenda(idVenda);
    }

    public List<ProdutosMaisVendidosResponse> consultarProdutosMaisVendidos(){
        return repositoy.findProdutosMaisVendidos();
    }
}
