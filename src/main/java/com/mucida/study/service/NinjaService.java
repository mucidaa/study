package com.mucida.study.service;

import com.mucida.study.model.NinjaModel;
import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.model.mapper.NinjaMapper;
import com.mucida.study.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> getAllNinjas() {
        return ninjaRepository.findAll()
                .stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id);
        return ninjaByID.map(ninjaMapper::map).orElse(null);
    }

    public void addNinja(NinjaDTO ninjaDTO) {
        ninjaRepository.save(ninjaMapper.map(ninjaDTO));
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel novoNinja = ninjaMapper.map(ninjaDTO);
            novoNinja.setId(id);
            return ninjaMapper.map(ninjaRepository.save(novoNinja));
        } else {
            return null;
        }
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
