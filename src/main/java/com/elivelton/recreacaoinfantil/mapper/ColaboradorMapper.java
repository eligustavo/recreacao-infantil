package com.elivelton.recreacaoinfantil.mapper;

import com.elivelton.recreacaoinfantil.domain.entity.Colaborador;
import com.elivelton.recreacaoinfantil.dto.ColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ColaboradorMapper {
    public static final ColaboradorMapper INSTANCE = Mappers.getMapper(ColaboradorMapper.class);

    public abstract Colaborador toModel(ColaboradorDTO colaboradorDTO);

    public abstract ColaboradorDTO toDTO(Colaborador colaborador);


}
