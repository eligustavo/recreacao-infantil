package com.elivelton.recreacaoinfantil.domain.service;

import com.elivelton.recreacaoinfantil.domain.entity.Crianca;
import com.elivelton.recreacaoinfantil.domain.repository.CriancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriancaService {

    private final CriancaRepository criancaRepository;

    public List<Crianca> listAll(){
        return criancaRepository.findAll();
    }


}
