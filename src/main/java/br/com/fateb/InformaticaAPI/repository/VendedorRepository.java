package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}