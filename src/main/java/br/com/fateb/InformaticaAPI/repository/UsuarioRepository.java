package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByLoginAndSenha(String email, String senha);

    Optional<Usuario> findByLogin(String login);

    @Query("SELECT u.idPerfilUsuario.nomePerfil FROM Usuario u WHERE u.login = :login")
    String findRoleByLogin(String login);
}