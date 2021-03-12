package com.elivelton.recreacaoinfantil.domain.repository;

import com.elivelton.recreacaoinfantil.domain.entity.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {



}
