package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.dto.request.VendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.VendaResponse;
import br.com.fateb.InformaticaAPI.entity.Produto;
import br.com.fateb.InformaticaAPI.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class VendaMapper {

    public static final VendaMapper INSTANCE = Mappers.getMapper(VendaMapper.class);

    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "idUsuario", ignore = true)
    public abstract Venda requestToEntity(VendaRequest request);

    @Mapping(target = "cliente", source = "idCliente" )
    @Mapping(target = "cliente.idCliente", source = "idCliente.id" )
    @Mapping(target = "usuario", source = "idUsuario")
    @Mapping(target = "usuario.idUsuario", source = "idUsuario.id")
    @Mapping(target = "usuario.idEmpresa", source = "idUsuario.idEmpresa.id")
    public abstract VendaResponse entityToResponse(Venda entity);


}
