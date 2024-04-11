package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.AutenticacaoRequest;
import br.com.fateb.InformaticaAPI.dto.request.PerfilUsuarioRequest;
import br.com.fateb.InformaticaAPI.dto.response.AutenticacaoResponse;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.UsuarioMapper;
import br.com.fateb.InformaticaAPI.repository.PerfilUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    private PerfilUsuarioRepository repositoy;

    private UsuarioService usuarioService;

    @Autowired
    public void PerfilUsuarioRepository(PerfilUsuarioRepository repositoy, UsuarioService usuarioService) {
        this.repositoy = repositoy;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public PerfilUsuario cadastrar(PerfilUsuarioRequest request) {

        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setTipoUsuario(request.tipoUsuario());
        return  repositoy.saveAndFlush(perfilUsuario);
    }

    public PerfilUsuario getUsuarioById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public AutenticacaoResponse autenticar(AutenticacaoRequest request){

       Usuario usuario = usuarioService.getUsuarioByEmailAndSenha(request.email(), request.senha());

        AutenticacaoResponse response;
       if (usuario != null){
           response = new AutenticacaoResponse("Autenticado");
       }
       else {
           response = new AutenticacaoResponse("Não Autenticado");
       }

       return response;

    }
}
