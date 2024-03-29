package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ClienteMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repositoy;

    private CidadeRepository cidadeRepository;

    @Autowired
    public void ClienteRepository(ClienteRepository repositoy, CidadeRepository cidadeRepository) {
        this.repositoy = repositoy;
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public Cliente cadastrar(ClienteRequest request) {

        Cidade cidade = cidadeRepository.findById(request.getCidade()).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));

        Cliente cliente = ClienteMapper.INSTANCE.requestToEntity(request);
        cliente.setCidade(cidade);
        return  repositoy.saveAndFlush(cliente);
    }

    @Transactional
    public void atualizar(Long id, ClienteRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        Cliente cliente = ClienteMapper.INSTANCE.requestToEntity(request);

        repositoy.updateClienteById(id, cliente.getNomeCliente(), cliente.getCpf(), cliente.getCidade().getIdCidade());
    }

    public Cliente getClienteById(Long id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> getAllClientes() {
        return repositoy.findAll();
    }
}
