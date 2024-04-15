package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.FornecedorMapper;
import br.com.fateb.InformaticaAPI.repository.FornecedorRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    FornecedorRepository repository;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void FornecedorRepository(FornecedorRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public Fornecedor cadastrar(Fornecedor request) {

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public void atualizarFornecedor(Fornecedor fornecedor) {

        Fornecedor existente = getFornecedorById(fornecedor.getId());

        atualizarEntidade.atualizarEntidade(fornecedor, existente);

        repository.saveAndFlush(existente);
    }


    public Fornecedor getFornecedorById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
    }

    public List<Fornecedor> getAllFornecedores() {
        return repository.findAll();
    }


}
