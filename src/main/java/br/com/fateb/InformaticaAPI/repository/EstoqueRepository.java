package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    @Query("SELECT e FROM Estoque e WHERE e.idProduto.id = :idProduto")
    public Estoque findByIdProduto(Integer idProduto);

    @Modifying
    @Query("UPDATE Estoque " +
            "SET quantidade = quantidade + :quantidade " +
            "WHERE id = :idProduto")
    void adicionarProduto(Integer idProduto, Integer quantidade);

    @Modifying
    @Query("UPDATE Estoque " +
            "SET quantidade = quantidade - :quantidade " +
            "WHERE id = :idProduto")
    void subtrairProduto(Integer idProduto, Integer quantidade);
}