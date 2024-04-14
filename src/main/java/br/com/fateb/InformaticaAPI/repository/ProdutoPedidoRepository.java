package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse;
import br.com.fateb.InformaticaAPI.entity.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer> {

    @Query(value = "SELECT pv FROM ProdutoPedido pv WHERE pv.idPedido.id = :idPedido")
    List<ProdutoPedido> produtosDeUmPedido(Integer idPedido);

    @Query("SELECT new br.com.fateb.InformaticaAPI.dto.response.ProdutosMaisVendidosResponse(" +
            "pv.idProduto.id, pv.idProduto.nomeProduto, SUM(pv.quantidade), SUM(pv.valorProdutoDesconto * pv.quantidade)) " +
            "FROM ProdutoPedido pv " +
            "GROUP BY pv.idProduto.id, pv.idProduto.nomeProduto " +
            "ORDER BY SUM(pv.quantidade) DESC")
    List<ProdutosMaisVendidosResponse> findProdutosMaisVendidos();
}