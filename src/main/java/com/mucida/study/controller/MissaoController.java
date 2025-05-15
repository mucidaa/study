package com.mucida.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @PostMapping
    public String addMissao(){
        return "Missao added";
    }

    @GetMapping
    public String getAllMissoes(){
        return "All Missoes got";
    }

    @GetMapping("/{id}")
    public String getMissaoById(@PathVariable int id){
        return "Missao got";
    }

    @PutMapping
    public String updateMissao(){
        return "Missao updated";
    }

    @DeleteMapping("/{id}")
    public String deleteMissao(@PathVariable int id){
        return "Missao deleted";
    }

}
