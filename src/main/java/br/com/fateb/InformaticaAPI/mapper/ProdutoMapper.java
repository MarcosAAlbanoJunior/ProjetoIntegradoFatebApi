package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

}
