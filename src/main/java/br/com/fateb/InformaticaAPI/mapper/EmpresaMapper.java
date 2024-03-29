package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.EmpresaRequest;
import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.Empresa;
import br.com.fateb.InformaticaAPI.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmpresaMapper {

    public static final EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);
    public abstract Empresa requestToEntity(EmpresaRequest request);
}
