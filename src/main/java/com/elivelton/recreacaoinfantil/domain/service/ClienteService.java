package com.elivelton.recreacaoinfantil.domain.service;

import com.elivelton.recreacaoinfantil.domain.entity.Cliente;
import com.elivelton.recreacaoinfantil.api.exceptions.BadRequestException;
import com.elivelton.recreacaoinfantil.dto.ClienteDTO;
import com.elivelton.recreacaoinfantil.mapper.ClienteMapper;
import com.elivelton.recreacaoinfantil.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Page<Cliente> listAllPageable(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public List<Cliente> listAll() {
        List<Cliente> list = clienteRepository.findAll();
        return list.stream().map(x -> new Cliente())
                .collect(Collectors.toList());
    }

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Not Found"));
    }

    @Transactional
    public Cliente save(ClienteDTO clienteDTO) {
        return clienteRepository.save(ClienteMapper.INSTANCE.toModel(clienteDTO));
    }

    public void delete(long id) {
        clienteRepository.delete(findById(id));
    }

    public void replace(ClienteDTO clienteDTO) {
        Cliente savedCliente = findById(clienteDTO.getId());
        Cliente cliente = ClienteMapper.INSTANCE.toModel(clienteDTO);
        cliente.setId(savedCliente.getId());
        clienteRepository.save(cliente);
    }

}
