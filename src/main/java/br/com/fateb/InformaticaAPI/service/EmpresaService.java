package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.EmpresaRequest;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.EmpresaMapper;
import br.com.fateb.InformaticaAPI.repository.EmpresaRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    EmpresaRepository repository;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void EmpresaRepository(EmpresaRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public Empresa cadastrar(Empresa request) {

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public Empresa atualizarEmpresa(Empresa request) {

        Empresa existente = getEmpresaById(request.getId());
        atualizarEntidade.atualizarEntidade(request, existente);
        return  repository.saveAndFlush(request);
    }

    public Empresa getEmpresaById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrado"));
    }

    public List<Empresa> getAllEmpresas() {
        return repository.findAll();
    }
}
