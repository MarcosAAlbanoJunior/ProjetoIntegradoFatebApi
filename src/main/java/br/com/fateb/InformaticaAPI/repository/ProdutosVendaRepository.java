package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.ProdutosVenda;
import br.com.fateb.InformaticaAPI.entity.id.ProdutosVendaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosVendaRepository extends JpaRepository<ProdutosVenda, ProdutosVendaId> {
}