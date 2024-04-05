package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Integer> {
}