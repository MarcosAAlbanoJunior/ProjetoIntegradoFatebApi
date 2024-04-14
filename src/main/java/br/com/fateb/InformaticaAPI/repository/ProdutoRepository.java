package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}