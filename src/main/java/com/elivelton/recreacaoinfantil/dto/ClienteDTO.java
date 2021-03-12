package com.elivelton.recreacaoinfantil.dto;

import com.elivelton.recreacaoinfantil.domain.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "Este campo é obrigatório")
    private String nome;

    @NotBlank(message = "Este campo é obrigatório")
    private String cpf;

    @NotBlank(message = "Este campo é obrigatório")
    private String contato;

    private TipoContato tipoContato;

}
