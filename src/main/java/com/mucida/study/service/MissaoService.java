package com.mucida.study.service;

import com.mucida.study.model.MissaoModel;
import com.mucida.study.model.dto.MissaoDTO;
import com.mucida.study.model.mapper.MissaoMapper;
import com.mucida.study.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> getAllMissoes() {
        return missaoRepository.findAll()
                .stream()
                .map(missaoMapper::map)
                .toList();
    }

    public MissaoDTO getMissaoById(Long id) {
        Optional<MissaoModel> missaoById = missaoRepository.findById(id);
        return missaoById.map(missaoMapper::map).orElse(null);
    }

    public void addMissao(MissaoDTO missaoDTO) {
        missaoRepository.save(missaoMapper.map(missaoDTO));
    }

    public MissaoDTO updateMissao(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missaoById = missaoRepository.findById(id);
        if (missaoById.isPresent()) {
            MissaoModel novaMissao = missaoMapper.map(missaoDTO);
            novaMissao.setId(id);
            return missaoMapper.map(missaoRepository.save(novaMissao));
        } else {
            return null;
        }
    }

    public void deleteMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
