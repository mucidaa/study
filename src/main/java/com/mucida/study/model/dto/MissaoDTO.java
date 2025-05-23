package com.mucida.study.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({ "email", "idade", "ninja_rank", "missao" })
    private List<NinjaDTO> ninjas;

}
