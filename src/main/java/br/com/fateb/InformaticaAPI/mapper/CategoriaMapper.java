package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.CategoriaRequest;
import br.com.fateb.InformaticaAPI.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CategoriaMapper {

    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

}
