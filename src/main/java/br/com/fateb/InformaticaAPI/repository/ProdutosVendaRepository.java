package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.ProdutosVenda;
import br.com.fateb.InformaticaAPI.entity.id.ProdutosVendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutosVendaRepository extends JpaRepository<ProdutosVenda, ProdutosVendaId> {

    @Query(value = "SELECT pv FROM ProdutosVenda pv WHERE pv.id.idVenda = :idVenda")
    List<ProdutosVenda> produtosDeUmaVenda(Integer idVenda);
}