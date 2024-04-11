package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContasReceberRepository extends JpaRepository<ContasReceber, Integer> {

    @Query("SELECT new br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse(cr.idVenda.idUsuario.id, cr.idVenda.idUsuario.nomeUsuario, SUM(DISTINCT cr.comissaoVenda)) " +
            "FROM ContasReceber cr " +
            "WHERE FUNCTION('YEAR', cr.idVenda.dataVenda) = :ano AND FUNCTION('MONTH', cr.idVenda.dataVenda) = :mes " +
            "GROUP BY cr.idVenda.idUsuario.id")
    List<ComissaoResponse> findComissaoPorUsuarioNoMesEAno(int ano, int mes);
}