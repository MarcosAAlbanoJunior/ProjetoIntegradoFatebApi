package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.AutenticacaoRequest;
import br.com.fateb.InformaticaAPI.dto.request.PerfilUsuarioRequest;
import br.com.fateb.InformaticaAPI.dto.response.AutenticacaoResponse;
import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.PerfilUsuarioRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    PerfilUsuarioRepository repository;

    AtualizarEntidade atualizarEntidade;


    @Autowired
    public void PerfilUsuarioRepository(PerfilUsuarioRepository repository, AtualizarEntidade atualizarEntidade) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    @Transactional
    public PerfilUsuario atualizarPerfilUsuario(PerfilUsuario request) {
        PerfilUsuario existente = getPerfilUsuarioById(request.getId());
        atualizarEntidade.atualizarEntidade(request, existente);
        return  repository.saveAndFlush(request);
    }

    @Transactional
    public PerfilUsuario cadastrar(PerfilUsuario request) {

        return  repository.saveAndFlush(request);
    }

    public PerfilUsuario getPerfilUsuarioById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public List<PerfilUsuario> getPerfisUsuarios(){
        return repository.findAll();
    }

}
