package com.elivelton.recreacaoinfantil.dto;

import com.elivelton.recreacaoinfantil.domain.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {

    private Long id;

    @NotBlank(message = "Este campo é obrigatório")
    private String nome;

    @NotBlank(message = "Este campo é obrigatório")
    private String genero;

    @NotBlank(message = "Este campo é obrigatório")
    private String contato;

    private TipoContato tipoContato;

    @NotNull(message = "Este campo é obrigatório")
    private boolean principal;

}
