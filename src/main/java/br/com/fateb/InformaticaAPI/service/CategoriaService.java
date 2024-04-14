package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.CategoriaRequest;
import br.com.fateb.InformaticaAPI.entity.Categoria;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.CategoriaMapper;
import br.com.fateb.InformaticaAPI.repository.CategoriaRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class CategoriaService {

    CategoriaRepository repository;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void CategoriaRepository(CategoriaRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public Categoria cadastrar(Categoria request) {

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public void atualizarEntidade(Categoria novaEntidade) {
        Categoria existente = repository.findById(novaEntidade.getId()).orElseThrow(() -> new NotFoundException("Entidade não encontrada"));
       atualizarEntidade.atualizarEntidade(novaEntidade, existente);
        repository.save(existente);
    }

    public Categoria getCategoriaById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }

    public List<Categoria> getAllCategorias() {
        return repository.findAll();
    }
}
