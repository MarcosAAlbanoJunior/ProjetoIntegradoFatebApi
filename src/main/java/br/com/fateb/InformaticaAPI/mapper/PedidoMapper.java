package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PedidoMapper {

    public static final PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);


}
