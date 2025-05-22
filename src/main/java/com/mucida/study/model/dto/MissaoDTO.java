package com.mucida.study.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {

    private String nome;
    private String dificuldade;
    private List<NinjaDTO> ninjas;

}
