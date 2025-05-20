package com.mucida.study.model.dto;

import com.mucida.study.model.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String name;
    private String email;
    private int idade;
    private String rank;
    private MissaoModel missao;

}
