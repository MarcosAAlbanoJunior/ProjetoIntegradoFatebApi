package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
}