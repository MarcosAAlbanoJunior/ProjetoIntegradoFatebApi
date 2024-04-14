package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import br.com.fateb.InformaticaAPI.entity.Vendedor;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.VendedorRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    VendedorRepository repositoy;

    UsuarioService usuarioService;

    EmpresaService empresaService;

    AtualizarEntidade atualizarEntidade;

    @Autowired
    public void VendedorRepository(VendedorRepository repositoy, AtualizarEntidade atualizarEntidade, UsuarioService usuarioService, EmpresaService empresaService) {
        this.repositoy = repositoy;
        this.atualizarEntidade = atualizarEntidade;
        this.usuarioService = usuarioService;
        this.empresaService = empresaService;
    }

    @Transactional
    public Vendedor cadastrar(Vendedor request) {

        Usuario usuario = usuarioService.getUsuarioById(request.getIdUsuario().getId());
        Empresa empresa = empresaService.getEmpresaById(request.getIdEmpresa().getId());

        request.setIdUsuario(usuario);
        request.setIdEmpresa(empresa);

        return  repositoy.saveAndFlush(request);
    }

    @Transactional
    public Vendedor atualizarVendedor(Vendedor request) {
        
        Vendedor existente = getVendedorById(request.getId());

        if(request.getIdUsuario().getId() != null){
            usuarioService.getUsuarioById(request.getIdUsuario().getId());
        }

        if(request.getIdEmpresa().getId() != null){
            empresaService.getEmpresaById(request.getIdEmpresa().getId());
        }

        atualizarEntidade.atualizarEntidade(request, existente);

        return  repositoy.save(request);
    }

    public Vendedor getVendedorById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Vendedor não encontrado"));
    }


    public List<Vendedor> getAllVendedors() {
        return repositoy.findAll();
    }
}
