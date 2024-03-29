package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}