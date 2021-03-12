package com.elivelton.recreacaoinfantil.mapper;

import com.elivelton.recreacaoinfantil.domain.entity.Cliente;
import com.elivelton.recreacaoinfantil.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toModel(ClienteDTO clienteDTO);

    public abstract ClienteDTO toDTO(Cliente cliente);

}
