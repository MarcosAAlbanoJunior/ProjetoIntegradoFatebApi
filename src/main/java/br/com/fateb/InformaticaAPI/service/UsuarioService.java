package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.UsuarioRequest;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.UsuarioMapper;
import br.com.fateb.InformaticaAPI.repository.UsuarioRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository repositoy;

    PerfilUsuarioService perfilUsuarioService;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void UsuarioRepository(UsuarioRepository repositoy, AtualizarEntidade atualizarEntidade, PerfilUsuarioService perfilUsuarioService) {
        this.repositoy = repositoy;
        this.atualizarEntidade = atualizarEntidade;
        this.perfilUsuarioService = perfilUsuarioService;
    }

    @Transactional
    public Usuario cadastrar(Usuario request) {

        PerfilUsuario perfilUsuario = perfilUsuarioService.getPerfilUsuarioById(request.getIdPerfilUsuario().getId());

        request.setIdPerfilUsuario(perfilUsuario);

        return  repositoy.saveAndFlush(request);
    }

    @Transactional
    public Usuario atualizarUsuario(Usuario request) {

        Usuario existente = getUsuarioById(request.getId());

        if (request.getIdPerfilUsuario().getId() != null){
            perfilUsuarioService.getPerfilUsuarioById(request.getIdPerfilUsuario().getId());
        }

        atualizarEntidade.atualizarEntidade(request, existente);

        return  repositoy.save(request);
    }

    public Usuario getUsuarioById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public Usuario getUsuarioByEmailAndSenha(String email, String senha){
        return repositoy.findByLoginAndSenha(email, senha).orElse(null);
    }

    public List<Usuario> getAllUsuarios() {
        return repositoy.findAll();
    }
}
