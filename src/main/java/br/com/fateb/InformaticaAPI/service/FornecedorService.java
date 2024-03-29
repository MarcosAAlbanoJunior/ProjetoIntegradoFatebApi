package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.FornecedorMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.ClienteRepository;
import br.com.fateb.InformaticaAPI.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    FornecedorRepository repository;

    @Autowired
    public void FornecedorRepository(FornecedorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Fornecedor cadastrar(FornecedorRequest request) {

        Fornecedor empresa = FornecedorMapper.INSTANCE.requestToEntity(request);
        return  repository.saveAndFlush(empresa);
    }


    public Fornecedor getFornecedorById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
    }

    public List<Fornecedor> getAllFornecedores() {
        return repository.findAll();
    }


}
