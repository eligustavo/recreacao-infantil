package com.elivelton.recreacaoinfantil.domain.service;

import com.elivelton.recreacaoinfantil.api.exceptions.BadRequestException;
import com.elivelton.recreacaoinfantil.domain.entity.Colaborador;
import com.elivelton.recreacaoinfantil.domain.repository.ColaboradorRepository;
import com.elivelton.recreacaoinfantil.dto.ColaboradorDTO;
import com.elivelton.recreacaoinfantil.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public Page<Colaborador> listAllPageable(Pageable pageable) {
        return colaboradorRepository.findAll(pageable);
    }

    public List<Colaborador> listAllNonPageable() {
        return colaboradorRepository.findAll();
    }

    public List<Colaborador> findByNome(String nome) {
        return colaboradorRepository.findByNome(nome);
    }

    public Colaborador findById(long id) {
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Not Found"));
    }

    @Transactional
    public Colaborador save(ColaboradorDTO colaboradorDTO) {
        return colaboradorRepository.save(ColaboradorMapper.INSTANCE.toModel(colaboradorDTO));
    }

    public void delete(long id) {
        colaboradorRepository.deleteById(id);
    }

    public void replace(ColaboradorDTO colaboradorDTO) {
        Colaborador savedColaborador = findById(colaboradorDTO.getId());
        Colaborador colaborador = ColaboradorMapper.INSTANCE.toModel(colaboradorDTO);
        colaborador.setId(savedColaborador.getId());
        colaboradorRepository.save(colaborador);
    }

}
