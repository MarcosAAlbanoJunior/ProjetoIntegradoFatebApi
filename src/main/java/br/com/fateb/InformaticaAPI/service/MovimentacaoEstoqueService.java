package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.MovimentoEstoque;
import br.com.fateb.InformaticaAPI.entity.MovimentoEstoque;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.MovimentoEstoqueRepository;
import br.com.fateb.InformaticaAPI.repository.TipoMovimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MovimentacaoEstoqueService {

    MovimentoEstoqueRepository repository;

    TipoMovimentoRepository tipoMovimentoRepository;

    ProdutoService produtoService;

    @Autowired
    public void MovimentoEstoqueRepository(MovimentoEstoqueRepository repository, TipoMovimentoRepository tipoMovimentoRepository, ProdutoService produtoService) {
        this.repository = repository;
        this.tipoMovimentoRepository = tipoMovimentoRepository;
        this.produtoService = produtoService;
    }

    @Transactional
    public MovimentoEstoque cadastrar(Integer idProduto, Integer tipoMovimento, Integer quantidade, Instant dataMov) {

        MovimentoEstoque movimentoEstoque = new MovimentoEstoque();

        movimentoEstoque.setDataMovimento(dataMov);
        movimentoEstoque.setTipoMovimento(tipoMovimentoRepository.findById(tipoMovimento).orElseThrow(() -> new NotFoundException("Tipo Movimento não Encontrado")));
        movimentoEstoque.setQuantidade(quantidade);
        movimentoEstoque.setIdProduto(produtoService.getProdutoById(idProduto));
        if(tipoMovimento == 2){
            produtoService.subtrairProduto(idProduto, quantidade);
        }
        return  repository.saveAndFlush(movimentoEstoque);
    }

    public MovimentoEstoque getMovimentoEstoqueById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("MovimentoEstoque não encontrada"));
    }

    public List<MovimentoEstoque> getAllMovimentoEstoques() {
        return repository.findAll();
    }
}
