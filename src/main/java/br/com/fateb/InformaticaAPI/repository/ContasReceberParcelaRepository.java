package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.ContasReceberParcela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContasReceberParcelaRepository extends JpaRepository<ContasReceberParcela, Integer> {

    List<ContasReceberParcela> findByIdContasReceberIdPedidoId(Integer idPedido);
}