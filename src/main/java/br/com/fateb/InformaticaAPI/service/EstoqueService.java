package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.Estoque;
import br.com.fateb.InformaticaAPI.entity.Pedido;
import br.com.fateb.InformaticaAPI.entity.Produto;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.EstoqueRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstoqueService {

    EstoqueRepository repository;

    ProdutoService produtoService;

    AtualizarEntidade atualizarEntidade;

    MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Autowired
    public void EstoqueRepository(EstoqueRepository repository, AtualizarEntidade atualizarEntidade, ProdutoService produtoService,
                                  MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
        this.produtoService = produtoService;
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @Transactional
    public Estoque cadastrar(Estoque request) {

        Produto produto = produtoService.getProdutoById(request.getIdProduto().getId());

        request.setIdProduto(produto);

        movimentacaoEstoqueService.cadastrar(produto.getId(), 2, request.getQuantidade(), LocalDate.now());

        return  repository.saveAndFlush(request);
    }

    public Estoque getEstoqueById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Estoque não encontrada"));
    }

    public Estoque getEstoqueByIdProduto(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Estoque não encontrado"));
    }

    public List<Estoque> getAllEstoques() {
        return repository.findAll();
    }

    @Transactional
    public void adicionarProduto(Integer idProduto, Integer quantidade){
        repository.adicionarProduto(idProduto, quantidade);
    }

    @Transactional
    public void subtrairProduto(Integer idProduto, Integer quantidade){
        repository.subtrairProduto(idProduto, quantidade);
        movimentacaoEstoqueService.cadastrar(idProduto, 1, quantidade, LocalDate.now());
    }

    @Transactional
    public Estoque atualizarEestoque(Estoque request) {

        Estoque existente = getEstoqueById(request.getId());

        if(request.getIdProduto() != null && request.getIdProduto().getId() != null){
            produtoService.getProdutoById(request.getIdProduto().getId());
        }

        if(request.getQuantidade() > existente.getQuantidade()){
            movimentacaoEstoqueService.cadastrar(existente.getIdProduto().getId(), 2, request.getQuantidade() - existente.getQuantidade(), LocalDate.now());
        }
        if(request.getQuantidade() < existente.getQuantidade()){
            movimentacaoEstoqueService.cadastrar(existente.getIdProduto().getId(), 1, existente.getQuantidade() - request.getQuantidade(), LocalDate.now());
        }

        atualizarEntidade.atualizarEntidade(request, existente);

        return  repository.saveAndFlush(existente);
    }
}
