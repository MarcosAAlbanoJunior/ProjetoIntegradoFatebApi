package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository repository;

    private AtualizarEntidade atualizarEntidade;

    @Autowired
    public void CidadeRepository(CidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cidade cadastrar(Cidade request) {

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public Cidade atualizarCidade(Cidade novaEntidade) {
        Cidade existente = repository.findById(novaEntidade.getId()).orElseThrow(() -> new NotFoundException("Entidade não encontrada"));
        // Usa reflexão para verificar e copiar valores não nulos

        atualizarEntidade.atualizarEntidade(novaEntidade, existente);

        return repository.save(existente);
    }


    public Cidade getCidadeById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));
    }

    public List<Cidade> getAllCidades() {
        return repository.findAll();
    }
}
