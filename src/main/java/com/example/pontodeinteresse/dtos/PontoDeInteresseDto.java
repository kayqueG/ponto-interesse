package com.example.pontodeinteresse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PontoDeInteresseDto {

    @NotNull(message = "Atributo nome é obrigatório")
    private String nome;

    @Min(value = 0 , message = "O valor deve ser um inteiro não negativo")
    @NotNull(message = "Atributo é obrigatório")
    private Integer cord_x;

    @Min(value = 0, message = "O valor deve ser um inteiro não negativo")
    @NotNull(message = "Atributo é obrigatório")
    private  Integer cord_y;

}
