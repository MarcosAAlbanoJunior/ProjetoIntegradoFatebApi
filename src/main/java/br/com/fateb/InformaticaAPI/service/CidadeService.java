package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.CidadeMapper;
import br.com.fateb.InformaticaAPI.repository.CidadeRepository;
import io.swagger.models.auth.In;
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


    public Cidade getCidadeById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));
    }

    public List<Cidade> getAllCidades() {
        return repositoy.findAll();
    }
}
