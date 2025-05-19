package com.mucida.study.controller;

import com.mucida.study.model.MissaoModel;
import com.mucida.study.service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping
    public void addMissao(@RequestBody MissaoModel missao){
        missaoService.addMissao(missao);
    }

    @GetMapping
    public List<MissaoModel> getAllMissoes(){
        return missaoService.getAllMissoes();
    }

    @GetMapping("/{id}")
    public MissaoModel getMissaoById(@PathVariable Long id){
        return missaoService.getMissaoById(id);
    }

    @PutMapping("/{id}")
    public void updateMissao(@PathVariable Long id, @RequestBody MissaoModel missao){
        missaoService.updateMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deleteMissao(@PathVariable Long id){
        missaoService.deleteMissao(id);
    }

}
