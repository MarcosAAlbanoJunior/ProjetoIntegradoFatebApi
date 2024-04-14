package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.FormaPagamento;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.FormaPagamentoRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    FormaPagamentoRepository repository;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void FormaPagamentoRepository(FormaPagamentoRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public FormaPagamento cadastrar(FormaPagamento request) {

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public void atualizarEntidade(FormaPagamento novaEntidade) {
        FormaPagamento existente = repository.findById(novaEntidade.getId()).orElseThrow(() -> new NotFoundException("Entidade não encontrada"));

        atualizarEntidade.atualizarEntidade(novaEntidade, existente);

        repository.save(existente);
    }

    public FormaPagamento getFormaPagamentoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Forma Pagamento não encontrada"));
    }

    public List<FormaPagamento> getAllFormaPagamentos() {
        return repository.findAll();
    }
}
