package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.CidadeRequest;
import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.CidadeMapper;
import br.com.fateb.InformaticaAPI.mapper.ClienteMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import br.com.fateb.InformaticaAPI.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository repositoy;

    @Autowired
    public void CidadeRepository(CidadeRepository repositoy) {
        this.repositoy = repositoy;
    }

    @Transactional
    public Cidade cadastrar(Cidade request) {

        return  repositoy.saveAndFlush(request);
    }

    @Transactional
    public void atualizar(Long id, CidadeRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        Cidade cidade = CidadeMapper.INSTANCE.requestToEntity(request);

        repositoy.updateCidadeById(id, cidade.getNomeCidade());
    }

    public Cidade getCidadeById(Long id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));
    }

    public List<Cidade> getAllCidades() {
        return repositoy.findAll();
    }
}
