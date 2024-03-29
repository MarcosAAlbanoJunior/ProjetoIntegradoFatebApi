package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.CidadeRequest;
import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CidadeMapper {

    public static final CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);
    public abstract Cidade requestToEntity(CidadeRequest request);
}