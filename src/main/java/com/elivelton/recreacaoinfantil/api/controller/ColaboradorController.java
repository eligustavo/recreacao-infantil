package com.elivelton.recreacaoinfantil.api.controller;

import com.elivelton.recreacaoinfantil.domain.entity.Colaborador;
import com.elivelton.recreacaoinfantil.domain.service.ColaboradorService;
import com.elivelton.recreacaoinfantil.dto.ColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<Page<Colaborador>> list(Pageable pageable) {
        return ResponseEntity.ok(colaboradorService.listAllPageable(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Colaborador>> listAll() {
        return ResponseEntity.ok(colaboradorService.listAllNonPageable());
    }

    @GetMapping("/find")
    public ResponseEntity<List<Colaborador>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(colaboradorService.findByNome(nome));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable long id) {
        return ResponseEntity.ok(colaboradorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Colaborador> save(@RequestBody @Valid ColaboradorDTO colaboradorDTO) {
        return new ResponseEntity<>(colaboradorService.save(colaboradorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        colaboradorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ColaboradorDTO colaboradorDTO) {
        colaboradorService.replace(colaboradorDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
