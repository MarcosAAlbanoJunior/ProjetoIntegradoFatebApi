package br.com.fateb.InformaticaAPI.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProdutosVendaId implements Serializable {
    private static final long serialVersionUID = -1283100930221264362L;
    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Column(name = "id_venda", nullable = false)
    private Integer idVenda;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProdutosVendaId entity = (ProdutosVendaId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.idVenda, entity.idVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idVenda);
    }

}