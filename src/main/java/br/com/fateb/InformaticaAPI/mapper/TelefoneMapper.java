package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.entity.ClienteTelefone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TelefoneMapper {

    public static final TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);



}
