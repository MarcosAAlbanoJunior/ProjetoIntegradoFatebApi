package br.com.fateb.InformaticaAPI.repository;

import br.com.fateb.InformaticaAPI.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Modifying
    @Query("UPDATE Produto " +
            "SET quantidadeEstoque = quantidadeEstoque + :quantidade " +
            "WHERE id = :idProduto")
    void adicionarProduto(Integer idProduto, Integer quantidade);

    @Modifying
    @Query("UPDATE Produto " +
            "SET quantidadeEstoque = quantidadeEstoque - :quantidade " +
            "WHERE id = :idProduto")
    void subtrairProduto(Integer idProduto, Integer quantidade);
}