package com.example.pontodeinteresse.controllers;

import com.example.pontodeinteresse.dtos.PontoDeInteresseDto;
import com.example.pontodeinteresse.entities.PontoDeInteresse;
import com.example.pontodeinteresse.services.PontoDeInteresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/poi")
@RequiredArgsConstructor
public class PontoDeInteresseController {

    private final PontoDeInteresseService pontoDeInteresseService;

    @GetMapping("/listar")
    public ResponseEntity<List<PontoDeInteresse>> listar(){
        return ResponseEntity.ok().body(pontoDeInteresseService.listarPontoDeInteresse());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PontoDeInteresseDto> cadastrar(@Valid @RequestBody PontoDeInteresseDto pontoDeInteresseDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(pontoDeInteresseService.cadastrarPontoDeInteresse(pontoDeInteresseDto));
    }

    @PostMapping("/listarPorProximidade")
    public  ResponseEntity<List<PontoDeInteresse>> listarPorProximidade(@RequestParam(value="x") Integer x,@RequestParam(value="y") Integer y,@RequestParam(value="dmax") Double distanciaMax){
        return ResponseEntity.ok(pontoDeInteresseService.listarPorProximidade(x,y,distanciaMax));
    }
}
