package com.mucida.study.service;

import com.mucida.study.model.MissaoModel;
import com.mucida.study.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> getAllMissoes() {
        return missaoRepository.findAll();
    }

    public MissaoModel getMissaoById(Long id) {
        return missaoRepository.findById(id).orElse(null);
    }

    public void addMissao(MissaoModel missaoModel) {
        missaoRepository.save(missaoModel);
    }

    public MissaoModel updateMissao(Long id, MissaoModel missaoModel) {
        missaoRepository.deleteById(id);
        missaoModel.setId(id);
        return missaoRepository.save(missaoModel);
    }

    public void deleteMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
