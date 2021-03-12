package com.elivelton.recreacaoinfantil.domain.repository;

import com.elivelton.recreacaoinfantil.domain.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> findByNome(String nome);

}
