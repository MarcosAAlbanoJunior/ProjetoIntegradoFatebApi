package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.TelefonesCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonesClienteRepository extends JpaRepository<TelefonesCliente, Integer> {
}