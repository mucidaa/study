package com.mucida.study.controller;

import com.mucida.study.model.dto.MissaoDTO;
import com.mucida.study.service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addMissao(@RequestBody MissaoDTO missaoDTO){
        missaoService.addMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping
    public ResponseEntity<List<MissaoDTO>> getAllMissoes(){
        return ResponseEntity.status(HttpStatus.OK).body(missaoService.getAllMissoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> getMissaoById(@PathVariable Long id){
        if (missaoService.getMissaoById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(missaoService.getMissaoById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissaoDTO> updateMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        if (missaoService.getMissaoById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(missaoService.updateMissao(id, missaoDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMissao(@PathVariable Long id){
        if (missaoService.getMissaoById(id) != null){
            missaoService.deleteMissao(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
