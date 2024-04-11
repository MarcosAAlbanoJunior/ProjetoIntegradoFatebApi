package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.UsuarioRequest;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.UsuarioMapper;
import br.com.fateb.InformaticaAPI.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repositoy;

    private EmpresaService empresaService;

    @Autowired
    public void UsuarioRepository(UsuarioRepository repositoy, EmpresaService empresaService) {
        this.repositoy = repositoy;
        this.empresaService = empresaService;
    }

    @Transactional
    public Usuario cadastrar(UsuarioRequest request) {

        Empresa empresa = empresaService.getEmpresaById(request.idEmpresa());

        Usuario usuario = UsuarioMapper.INSTANCE.requestToEntity(request);
        usuario.setIdEmpresa(empresa);
        return  repositoy.saveAndFlush(usuario);
    }

    public Usuario getUsuarioById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public Usuario getUsuarioByEmailAndSenha(String email, String senha){
        return repositoy.findByEmailAndSenha(email, senha).orElse(null);
    }

    public List<Usuario> getAllUsuarios() {
        return repositoy.findAll();
    }
}
