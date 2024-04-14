package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ClienteMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.ClienteRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;

    private CidadeRepository cidadeRepository;

    private AtualizarEntidade atualizarEntidade;

    @Autowired
    public void ClienteRepository(ClienteRepository repositoy, CidadeRepository cidadeRepository, AtualizarEntidade atualizarEntidade) {
        this.repository = repositoy;
        this.cidadeRepository = cidadeRepository;
        this.atualizarEntidade = atualizarEntidade;

    }

    @Transactional
    public Cliente cadastrar(Cliente request) {

        Cidade cidade = cidadeRepository.findById(request.getIdCidade().getId()).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));

        request.setIdCidade(cidade);
        return  repository.saveAndFlush(request);
    }

    public Cliente getClienteById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }
    @Transactional
    public void atualizarEntidade(Cliente novaEntidade) {
        Cliente existente = repository.findById(novaEntidade.getId()).orElseThrow(() -> new NotFoundException("Entidade não encontrada"));

        atualizarEntidade.atualizarEntidade(novaEntidade, existente);

        repository.save(existente);
    }
}
