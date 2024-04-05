package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.CategoriaRequest;
import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.entity.Categoria;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.CategoriaMapper;
import br.com.fateb.InformaticaAPI.mapper.FornecedorMapper;
import br.com.fateb.InformaticaAPI.repository.CategoriaRepository;
import br.com.fateb.InformaticaAPI.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    CategoriaRepository repository;

    @Autowired
    public void CategoriaRepository(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Categoria cadastrar(CategoriaRequest request) {

        Categoria empresa = CategoriaMapper.INSTANCE.requestToEntity(request);
        return  repository.saveAndFlush(empresa);
    }

    public Categoria getCategoriaById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }

    public List<Categoria> getAllCategorias() {
        return repository.findAll();
    }
}
