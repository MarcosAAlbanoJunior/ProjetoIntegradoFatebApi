package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.EmpresaRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
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

    CidadeService cidadeService;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void EmpresaRepository(EmpresaRepository repository, AtualizarEntidade atualizarEntidade, CidadeService cidadeService) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
        this.cidadeService = cidadeService;
    }

    @Transactional
    public Empresa cadastrar(Empresa request) {

        Cidade cidade = cidadeService.getCidadeById(request.getIdCidade().getId());

        return  repository.saveAndFlush(request);
    }

    @Transactional
    public Empresa atualizarEmpresa(Empresa request) {

        Empresa existente = getEmpresaById(request.getId());
        atualizarEntidade.atualizarEntidade(request, existente);
        return  repository.saveAndFlush(existente);
    }

    public Empresa getEmpresaById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrado"));
    }

    public List<Empresa> getAllEmpresas() {
        return repository.findAll();
    }
}
