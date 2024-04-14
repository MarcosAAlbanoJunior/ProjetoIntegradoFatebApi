package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}