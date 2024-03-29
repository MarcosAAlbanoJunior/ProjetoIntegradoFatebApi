package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ClienteMapper;
import br.com.fateb.InformaticaAPI.mapper.ProdutoMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.ClienteRepository;
import br.com.fateb.InformaticaAPI.repository.FornecedorRepository;
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

        Fornecedor fornecedor = fornecedorService.getFornecedorById(request.getIdFornecedor());

        Categoria categoria = categoriaService.getCategoriaById(request.getIdCategoria());

        Produto produto = ProdutoMapper.INSTANCE.requestToEntity(request);
        produto.setIdFornecedor(fornecedor);
        produto.setIdCategoria(categoria);

        return  repositoy.saveAndFlush(produto);
    }

    public Produto getProdutoById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> getAllProdutos() {
        return repositoy.findAll();
    }
}
