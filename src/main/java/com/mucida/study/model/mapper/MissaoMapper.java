package com.mucida.study.model.mapper;

import com.mucida.study.model.MissaoModel;
import com.mucida.study.model.dto.MissaoDTO;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    private final NinjaMapper ninjaMapper;

    public MissaoMapper(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();

        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setNinjas(missaoModel.getNinjas().stream().map(ninjaMapper::map).toList());

        return missaoDTO;
    }

    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());

        return missaoModel;
    }

}
