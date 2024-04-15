package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.ClienteTelefone;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.TelefoneMapper;
import br.com.fateb.InformaticaAPI.repository.ClienteTelefoneRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    ClienteTelefoneRepository repository;

    ClienteService clienteService;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void TelefoneRepository(ClienteTelefoneRepository repository, ClienteService clienteService, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public void cadastrar(ClienteTelefone request) {

        Cliente cliente = clienteService.getClienteById(request.getIdCliente().getId());

        request.setIdCliente(cliente);

        repository.saveAndFlush(request);

    }

    @Transactional
    public void atualizarTelefone(ClienteTelefone request) {

        ClienteTelefone existente = getTelefoneById(request.getId());

        clienteService.getClienteById(request.getIdCliente().getId());

        atualizarEntidade.atualizarEntidade(request, existente);

        repository.saveAndFlush(existente);

    }

    public ClienteTelefone getTelefoneById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Telefone não encontrado"));
    }

    public List<ClienteTelefone> getAllTelefones() {
        return repository.findAll();
    }
}
