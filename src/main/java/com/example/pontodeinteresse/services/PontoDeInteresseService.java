package com.example.pontodeinteresse.services;

import com.example.pontodeinteresse.dtos.PontoDeInteresseDto;
import com.example.pontodeinteresse.entities.PontoDeInteresse;
import com.example.pontodeinteresse.repositories.PontoDeInteresseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PontoDeInteresseService {

    private final PontoDeInteresseRepository pontoDeInteresseRepository;

    public PontoDeInteresseDto cadastrarPontoDeInteresse(PontoDeInteresseDto poi){
        PontoDeInteresse novoPoi = PontoDeInteresse.builder().build();
        BeanUtils.copyProperties(poi,novoPoi);
        pontoDeInteresseRepository.save(novoPoi);

        return  poi;
    }

    public List<PontoDeInteresse> listarPontoDeInteresse(){
        return pontoDeInteresseRepository.findAll();
    }
}
