package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoVendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.ProdutoResponse;
import br.com.fateb.InformaticaAPI.entity.ProdutosVenda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoVendaMapper {

    public static final ProdutoVendaMapper INSTANCE = Mappers.getMapper(ProdutoVendaMapper.class);

    @Mapping(target = "idProduto", ignore = true)
    @Mapping(target = "idVenda", ignore = true)
    @Mapping(target = "precoUnitario", ignore = true)
    public abstract ProdutosVenda requestToEntity(ProdutoVendaRequest request);

    @Mapping(target = "id", source = "idProduto.id")
    @Mapping(target = "nomeProduto", source = "idProduto.nomeProduto")
    @Mapping(target = "preco", source = "idProduto.preco")
    public abstract ProdutoResponse entityToResponse(ProdutosVenda entity);
}
