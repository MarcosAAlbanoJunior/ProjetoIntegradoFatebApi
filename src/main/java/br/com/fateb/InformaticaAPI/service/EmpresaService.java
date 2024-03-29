package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.EmpresaRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.EmpresaMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private EmpresaRepository repositoy;

    @Autowired
    public void EmpresaRepository(EmpresaRepository repositoy) {
        this.repositoy = repositoy;
    }

    @Transactional
    public Empresa cadastrar(EmpresaRequest request) {

        Empresa empresa = EmpresaMapper.INSTANCE.requestToEntity(request);
        return  repositoy.saveAndFlush(empresa);
    }

    public Empresa getEmpresaById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrado"));
    }

    public List<Empresa> getAllEmpresas() {
        return repositoy.findAll();
    }
}
