package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.AutenticacaoRequest;
import br.com.fateb.InformaticaAPI.dto.request.UsuarioRequest;
import br.com.fateb.InformaticaAPI.dto.response.AutenticacaoResponse;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.UsuarioMapper;
import br.com.fateb.InformaticaAPI.repository.UsuarioRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository repositoy;

    PerfilUsuarioService perfilUsuarioService;

    AtualizarEntidade atualizarEntidade;

    PasswordEncoder passwordEncoder;

    @Autowired
    public void UsuarioRepository(UsuarioRepository repositoy, AtualizarEntidade atualizarEntidade, PerfilUsuarioService perfilUsuarioService,
                                  PasswordEncoder passwordEncoder) {
        this.repositoy = repositoy;
        this.atualizarEntidade = atualizarEntidade;
        this.perfilUsuarioService = perfilUsuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario cadastrar(Usuario request) {

        PerfilUsuario perfilUsuario = perfilUsuarioService.getPerfilUsuarioById(request.getIdPerfilUsuario().getId());

        request.setIdPerfilUsuario(perfilUsuario);

        request.setSenha(passwordEncoder.encode(request.getSenha()));

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

    public Usuario getUsuarioById(Long id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public Usuario getUsuarioByEmailAndSenha(String email, String senha){
        return repositoy.findByLoginAndSenha(email, senha).orElse(null);
    }

    public List<Usuario> getAllUsuarios() {
        return repositoy.findAll();
    }

    public AutenticacaoResponse autenticar(AutenticacaoRequest request){

       Usuario usuario = getUsuarioByEmailAndSenha(request.email(), request.senha());

       AutenticacaoResponse response;

       if (usuario != null){
           response = new AutenticacaoResponse("Autenticado");
       }
       else {
           response = new AutenticacaoResponse("Senha ou Email não encontrados");
       }

       return response;

    }

    public Usuario buscarPorLogin(String login){
        return repositoy.findByLogin(login).orElseThrow(() -> new NotFoundException("Usuario com este login não encontrado"));
    }

    public String buscarPerfilPorLogin(String login) {
        return repositoy.findRoleByLogin(login);
    }
}
