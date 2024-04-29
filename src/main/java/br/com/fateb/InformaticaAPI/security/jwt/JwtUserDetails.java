package br.com.fateb.InformaticaAPI.security.jwt;

import br.com.fateb.InformaticaAPI.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetails extends User {

    private Usuario usuario;

    public JwtUserDetails(Usuario usuario) {
        super(usuario.getLogin(), usuario.getSenha(), AuthorityUtils.createAuthorityList(usuario.getIdPerfilUsuario().getNomePerfil()));
        this.usuario = usuario;
    }

    public Long getId(){
        return this.usuario.getId();
    }

    public String getRole(){
        return this.usuario.getIdPerfilUsuario().getNomePerfil();
    }
}
