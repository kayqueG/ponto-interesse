package com.example.pontodeinteresse.services;

import com.example.pontodeinteresse.dtos.PontoDeInteresseDto;
import com.example.pontodeinteresse.entities.PontoDeInteresse;
import com.example.pontodeinteresse.repositories.PontoDeInteresseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<PontoDeInteresse> listarPorProximidade(Integer x, Integer y, Double distancia_max){

        List<PontoDeInteresse> lista=pontoDeInteresseRepository.findAll();

        List<PontoDeInteresse> listaRetorno=new ArrayList<>();

        lista.stream().filter(poi->distanciaMaxima(x,y, poi.getCord_x(),poi.getCord_y())<=distancia_max).forEach(poi->listaRetorno.add(poi));

        return listaRetorno;
    }

    public Double distanciaMaxima(Integer x_a, Integer y_a, Integer x_b, Integer y_b){

        return Math.sqrt(Math.pow(x_b-x_a,2)+Math.pow(y_b-y_a,2));
    }
}
