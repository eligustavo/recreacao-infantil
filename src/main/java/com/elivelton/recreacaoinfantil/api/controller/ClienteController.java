package com.elivelton.recreacaoinfantil.api.controller;

import com.elivelton.recreacaoinfantil.domain.entity.Cliente;
import com.elivelton.recreacaoinfantil.domain.service.ClienteService;
import com.elivelton.recreacaoinfantil.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<Cliente>> listAllPageable(Pageable pageable){
        return ResponseEntity.ok(clienteService.listAllPageable(pageable));
    }

     @GetMapping("/all")
     public ResponseEntity<List<Cliente>> listAll(){
         return ResponseEntity.ok(clienteService.listAll());
     }

    @GetMapping("/find")
    public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(clienteService.findByNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam long id){
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClienteDTO clienteDTO){
        clienteService.replace(clienteDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
