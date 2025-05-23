package com.mucida.study.model.mapper;

import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNinjaRank(ninjaDTO.getNinjaRank());
        ninjaModel.setMissao(ninjaDTO.getMissao());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {

        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setNinjaRank(ninjaModel.getNinjaRank());
        ninjaDTO.setMissao(ninjaModel.getMissao());

        return ninjaDTO;
    }

}
