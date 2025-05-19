package com.mucida.study.service;

import com.mucida.study.model.NinjaModel;
import com.mucida.study.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public void addNinja(NinjaModel ninjaModel) {
        ninjaRepository.save(ninjaModel);
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
