package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.VendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.ContasReceberResponse;
import br.com.fateb.InformaticaAPI.dto.response.VendaResponse;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import br.com.fateb.InformaticaAPI.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ContasReceberMapper {

    public static final ContasReceberMapper INSTANCE = Mappers.getMapper(ContasReceberMapper.class);

    @Mapping(target = "idVenda", source = "idVenda.id")
    @Mapping(target = "cliente.idCliente", source = "idVenda.idCliente.id" )
    @Mapping(target = "cliente.nomeCliente", source = "idVenda.idCliente.nomeCliente" )
    @Mapping(target = "usuario.nomeUsuario", source = "idVenda.idUsuario.nomeUsuario")
    @Mapping(target = "usuario.idUsuario", source = "idVenda.idUsuario.id")
    @Mapping(target = "dataVenda", source = "idVenda.dataVenda")
    @Mapping(target = "status", source = "statusPagamento")
    public abstract ContasReceberResponse entityToResponse(ContasReceber entity);


}
