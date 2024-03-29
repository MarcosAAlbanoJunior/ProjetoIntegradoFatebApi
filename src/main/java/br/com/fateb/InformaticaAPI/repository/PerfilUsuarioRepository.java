package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Integer> {
}