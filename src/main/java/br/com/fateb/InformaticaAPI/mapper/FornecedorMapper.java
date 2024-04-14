package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FornecedorMapper {

    public static final FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);

}
