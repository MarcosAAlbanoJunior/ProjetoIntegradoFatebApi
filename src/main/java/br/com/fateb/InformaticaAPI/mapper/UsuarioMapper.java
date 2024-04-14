package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.UsuarioRequest;
import br.com.fateb.InformaticaAPI.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

}
