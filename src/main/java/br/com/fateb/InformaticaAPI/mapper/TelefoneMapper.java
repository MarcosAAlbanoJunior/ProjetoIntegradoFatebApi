package br.com.fateb.InformaticaAPI.mapper;

import br.com.fateb.InformaticaAPI.dto.request.TelefoneRequest;
import br.com.fateb.InformaticaAPI.dto.request.VendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.VendaResponse;
import br.com.fateb.InformaticaAPI.entity.TelefonesPessoa;
import br.com.fateb.InformaticaAPI.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TelefoneMapper {

    public static final TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);


    public abstract TelefonesPessoa requestToEntity(TelefoneRequest request);


}
