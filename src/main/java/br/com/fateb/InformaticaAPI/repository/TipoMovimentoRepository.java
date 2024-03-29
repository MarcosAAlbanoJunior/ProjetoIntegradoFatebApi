package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.TipoMovimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMovimentoRepository extends JpaRepository<TipoMovimento, Integer> {
}