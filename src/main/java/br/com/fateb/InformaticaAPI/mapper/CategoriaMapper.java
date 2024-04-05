package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.CategoriaRequest;
import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.Categoria;
import br.com.fateb.InformaticaAPI.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CategoriaMapper {

    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    public abstract Categoria requestToEntity(CategoriaRequest request);
}
