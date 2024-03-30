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

    @Mapping(target = "valorTotal", source = "valor" )
    @Mapping(target = "idVenda", source = "idVenda.id")
    @Mapping(target = "cliente.idCliente", source = "idVenda.idCliente.id" )
    @Mapping(target = "cliente.nomeCliente", source = "idVenda.idCliente.nomeCliente" )
    @Mapping(target = "cliente.documento", source = "idVenda.idCliente.documento" )
    @Mapping(target = "cliente.email", source = "idVenda.idCliente.email" )
    @Mapping(target = "usuario.nomeUsuario", source = "idVenda.idUsuario.nomeUsuario")
    @Mapping(target = "usuario.cpfUsuario", source = "idVenda.idUsuario.cpfUsuario")
    @Mapping(target = "usuario.email", source = "idVenda.idUsuario.email")
    @Mapping(target = "usuario.idUsuario", source = "idVenda.idUsuario.id")
    @Mapping(target = "usuario.idEmpresa", source = "idVenda.idUsuario.idEmpresa.id")
    @Mapping(target = "dataVenda", source = "idVenda.dataVenda")
    public abstract ContasReceberResponse entityToResponse(ContasReceber entity);


}
