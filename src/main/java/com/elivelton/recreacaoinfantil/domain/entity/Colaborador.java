package com.elivelton.recreacaoinfantil.domain.entity;


import com.elivelton.recreacaoinfantil.domain.enums.TipoContato;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String genero;
    private String contato;

    private TipoContato tipoContato;

    private boolean principal;

}
