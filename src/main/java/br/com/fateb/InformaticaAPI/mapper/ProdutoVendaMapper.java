package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoPedidoRequest;
import br.com.fateb.InformaticaAPI.dto.response.PedidoResponse;
import br.com.fateb.InformaticaAPI.entity.ProdutoPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoVendaMapper {

    public static final ProdutoVendaMapper INSTANCE = Mappers.getMapper(ProdutoVendaMapper.class);

}
