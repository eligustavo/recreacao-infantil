package com.elivelton.recreacaoinfantil.api.controller;

import com.elivelton.recreacaoinfantil.domain.entity.Crianca;
import com.elivelton.recreacaoinfantil.domain.service.CriancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/criancas")
@RequiredArgsConstructor
public class CriancaController {

    private final CriancaService criancaService;

    @GetMapping
    public ResponseEntity<List<Crianca>> listAll(){
        return ResponseEntity.ok(criancaService.listAll());
    }

}
