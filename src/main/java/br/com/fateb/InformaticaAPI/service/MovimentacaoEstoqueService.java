package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.MovimentoEstoque;
import br.com.fateb.InformaticaAPI.entity.TipoMovimentoEstoque;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.MovimentoEstoqueRepository;
import br.com.fateb.InformaticaAPI.service.TipoMovimentoEstoqueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovimentacaoEstoqueService {

    MovimentoEstoqueRepository repository;

    TipoMovimentoEstoqueService tipoMovimentoService;

    ProdutoService produtoService;

    @Autowired
    public void MovimentoEstoqueRepository(MovimentoEstoqueRepository repository, TipoMovimentoEstoqueService tipoMovimentoService, ProdutoService produtoService) {
        this.repository = repository;
        this.tipoMovimentoService = tipoMovimentoService;
        this.produtoService = produtoService;
    }

    @Transactional
    public MovimentoEstoque cadastrar(Integer idProduto, Integer idTipoMovimento, Integer quantidade, LocalDate dataMov) {

        MovimentoEstoque movimentoEstoque = new MovimentoEstoque();

        movimentoEstoque.setDataMovimento(dataMov);
        movimentoEstoque.setIdTipoMovimento(tipoMovimentoService.getTipoMovimentoById(idTipoMovimento));
        movimentoEstoque.setQuantidade(quantidade);
        movimentoEstoque.setIdProduto(produtoService.getProdutoById(idProduto));


        return  repository.saveAndFlush(movimentoEstoque);
    }

    public MovimentoEstoque getMovimentoEstoqueById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("MovimentoEstoque não encontrada"));
    }

    public List<MovimentoEstoque> getAllMovimentoEstoques() {
        return repository.findAll();
    }


}
