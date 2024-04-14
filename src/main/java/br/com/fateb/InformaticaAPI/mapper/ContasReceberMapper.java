package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.response.ContasReceberResponse;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ContasReceberMapper {

    public static final ContasReceberMapper INSTANCE = Mappers.getMapper(ContasReceberMapper.class);



}
