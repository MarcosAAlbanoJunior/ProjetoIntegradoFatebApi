package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.TipoMovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMovimentoEstoqueRepository extends JpaRepository<TipoMovimentoEstoque, Integer> {
}