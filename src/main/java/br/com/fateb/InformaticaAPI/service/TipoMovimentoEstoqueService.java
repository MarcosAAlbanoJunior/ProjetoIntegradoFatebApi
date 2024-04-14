package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.Produto;
import br.com.fateb.InformaticaAPI.entity.TipoMovimentoEstoque;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.TipoMovimentoEstoqueRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMovimentoEstoqueService {

    TipoMovimentoEstoqueRepository repository;

    AtualizarEntidade atualizarEntidade;

    ProdutoService produtoService;

    @Autowired
    public void TipoMovimentoEstoqueRepository(TipoMovimentoEstoqueRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public TipoMovimentoEstoque cadastrar(TipoMovimentoEstoque request) {

        return repository.saveAndFlush(request);
    }

    @Transactional
    public TipoMovimentoEstoque atualizarMovimentoEstoque(TipoMovimentoEstoque request) {

        TipoMovimentoEstoque existente = getTipoMovimentoById(request.getId());
        atualizarEntidade.atualizarEntidade(request, existente);
        return repository.saveAndFlush(request);
    }

    public TipoMovimentoEstoque getTipoMovimentoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Tipo Movimento não encontrado"));
    }

    public List<TipoMovimentoEstoque> getAllTipoMovimentos() {
        return repository.findAll();
    }
}
