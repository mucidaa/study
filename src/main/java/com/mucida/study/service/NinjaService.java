package com.mucida.study.service;

import com.mucida.study.model.NinjaModel;
import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.model.mapper.NinjaMapper;
import com.mucida.study.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public void addNinja(NinjaDTO ninjaDTO) {
        ninjaRepository.save(ninjaMapper.map(ninjaDTO));
    }

    public NinjaModel updateNinja(Long id, NinjaModel ninjaModel) {
        if (ninjaRepository.existsById(id)) {
            ninjaModel.setId(id);
            return ninjaRepository.save(ninjaModel);
        }
        return null;
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
