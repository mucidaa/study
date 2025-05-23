package com.mucida.study.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mucida.study.model.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "email", "idade", "ninja_rank", "missao" })
public class NinjaDTO {

    private long id;
    private String name;
    private String email;
    private int idade;
    @JsonProperty("ninja_rank")
    private String ninjaRank;
    private MissaoModel missao;

}
