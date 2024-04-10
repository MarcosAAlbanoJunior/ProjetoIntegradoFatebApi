package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ProdutoMapper;
import br.com.fateb.InformaticaAPI.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository repositoy;

    private FornecedorService fornecedorService;

    private CategoriaService categoriaService;

    @Autowired
    public void ProdutoRepository(ProdutoRepository repositoy, FornecedorService fornecedorService, CategoriaService categoriaService) {
        this.repositoy = repositoy;
        this.fornecedorService = fornecedorService;
        this.categoriaService = categoriaService;
    }

    @Transactional
    public Produto cadastrar(ProdutoRequest request) {

        Fornecedor fornecedor = fornecedorService.getFornecedorById(request.idFornecedor());

        Categoria categoria = categoriaService.getCategoriaById(request.idCategoria());

        Produto produto = ProdutoMapper.INSTANCE.requestToEntity(request);
        produto.setIdFornecedor(fornecedor);
        produto.setIdCategoria(categoria);

        return  repositoy.saveAndFlush(produto);
    }

    @Transactional
    public void adicionarProduto(Integer idProduto, Integer quantidade){
        repositoy.adicionarProduto(idProduto, quantidade);
    }

    @Transactional
    public void subtrairProduto(Integer idProduto, Integer quantidade){
        repositoy.subtrairProduto(idProduto, quantidade);
    }

    public Produto getProdutoById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> getAllProdutos() {
        return repositoy.findAll();
    }
}
