package br.com.fateb.InformaticaAPI.repository;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Modifying
    @Query("UPDATE Cliente c SET c.nomeCliente = :novoNome, c.cpf = :novoCpf, c.cidade = :novaCidade WHERE c.idCliente = :id")
    void updateClienteById(Long id, String novoNome, String novoCpf, Long novaCidade);
}

