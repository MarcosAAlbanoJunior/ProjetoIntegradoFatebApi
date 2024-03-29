package br.com.fateb.InformaticaAPI.repository;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Modifying
    @Query("UPDATE Cidade c SET c.nomeCidade = :novoNome WHERE c.idCidade = :id")
    void updateCidadeById(Long id, String novoNome);
}

