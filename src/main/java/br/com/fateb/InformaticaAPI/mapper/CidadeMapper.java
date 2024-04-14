package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.CidadeRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CidadeMapper {

    public static final CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);
}