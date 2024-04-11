package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.TelefonesPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonesPessoasRepository extends JpaRepository<TelefonesPessoa, Integer> {
}