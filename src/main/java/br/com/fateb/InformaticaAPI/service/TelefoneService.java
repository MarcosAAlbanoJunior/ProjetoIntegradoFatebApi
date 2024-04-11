package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.TelefonesPessoa;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.TelefoneMapper;
import br.com.fateb.InformaticaAPI.repository.TelefonesPessoasRepository;
import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    TelefonesPessoasRepository repository;

    FornecedorService fornecedorService;

    ClienteService clienteService;

    @Autowired
    public void TelefoneRepository(TelefonesPessoasRepository repository, FornecedorService fornecedorService,  ClienteService clienteService) {
        this.repository = repository;
        this.fornecedorService = fornecedorService;
        this.clienteService = clienteService;
    }

    @Transactional
    public void cadastrar(TelefoneRequest request) {

        if (request.tipoPessoa().equals("Fornecedor")){
            fornecedorService.getFornecedorById(request.idPessoa());
        }
        else {
            clienteService.getClienteById(request.idPessoa());
        }

        repository.saveAndFlush(TelefoneMapper.INSTANCE.requestToEntity(request));
    }

    public TelefonesPessoa getTelefoneById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Telefone não encontrado"));
    }

    public List<TelefonesPessoa> getAllTelefones() {
        return repository.findAll();
    }
}
