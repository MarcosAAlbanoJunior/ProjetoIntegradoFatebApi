package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ProdutoMapper;
import br.com.fateb.InformaticaAPI.repository.ProdutoRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository repository;

    FornecedorService fornecedorService;

    CategoriaService categoriaService;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void ProdutoRepository(ProdutoRepository repository, FornecedorService fornecedorService, CategoriaService categoriaService,
                                  AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.fornecedorService = fornecedorService;
        this.categoriaService = categoriaService;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public Produto cadastrar(Produto request) {

        Fornecedor fornecedor = fornecedorService.getFornecedorById(request.getIdFornecedor().getId());

        Categoria categoria = categoriaService.getCategoriaById(request.getIdCategoria().getId());

        request.setIdFornecedor(fornecedor);

        request.setIdCategoria(categoria);

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public Produto atualizarProduto(Produto request) {

        Produto existente = getProdutoById(request.getId());

        if (request.getIdFornecedor() != null && request.getIdFornecedor().getId() != null) {
            Fornecedor fornecedor = fornecedorService.getFornecedorById(request.getIdFornecedor().getId());
        }

        if(request.getIdCategoria() != null && request.getIdCategoria().getId() != null) {
            Categoria categoria = categoriaService.getCategoriaById(request.getIdCategoria().getId());
        }

        atualizarEntidade.atualizarEntidade(request, existente);

        return  repository.saveAndFlush(existente);
    }

    public Produto getProdutoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }
}
