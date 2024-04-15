package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}