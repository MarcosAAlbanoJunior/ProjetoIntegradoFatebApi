package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse;
import br.com.fateb.InformaticaAPI.entity.ProdutosVenda;
import br.com.fateb.InformaticaAPI.entity.id.ProdutosVendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutosVendaRepository extends JpaRepository<ProdutosVenda, ProdutosVendaId> {

    @Query(value = "SELECT pv FROM ProdutosVenda pv WHERE pv.id.idVenda = :idVenda")
    List<ProdutosVenda> produtosDeUmaVenda(Integer idVenda);

    @Query("SELECT new br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse(" +
            "pv.idProduto.id, pv.idProduto.nomeProduto, SUM(pv.quantidade), SUM(pv.precoUnitario * pv.quantidade)) " +
            "FROM ProdutosVenda pv " +
            "GROUP BY pv.idProduto.id, pv.idProduto.nomeProduto " +
            "ORDER BY SUM(pv.quantidade) DESC")
    List<ProdutosMaisVendidosResponse> findProdutosMaisVendidos();
}