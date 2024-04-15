package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContasReceberRepository extends JpaRepository<ContasReceber, Integer> {

    @Query("SELECT new br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse(" +
            "v.id, v.nomeVendedor, " +
            "SUM((CASE WHEN pp.valorProdutoDesconto IS NOT NULL THEN pp.valorProdutoDesconto ELSE pp.valorProdutoReal END * pp.quantidade) / 10)) " +
            "FROM ContasReceber cr " +
            "JOIN Pedido p ON cr.idPedido = p " +
            "JOIN Vendedor v ON p.idVendedor = v " +
            "JOIN ProdutoPedido pp ON pp.idPedido = p " +
            "WHERE FUNCTION('YEAR', p.dataVenda) = :ano AND FUNCTION('MONTH', p.dataVenda) = :mes " +
            "GROUP BY v.id, v.nomeVendedor")
    List<ComissaoResponse> findComissaoPorUsuarioNoMesEAno(int ano, int mes);

}