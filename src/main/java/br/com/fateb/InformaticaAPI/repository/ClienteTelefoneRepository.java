package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.ClienteTelefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteTelefoneRepository extends JpaRepository<ClienteTelefone, Integer> {
}