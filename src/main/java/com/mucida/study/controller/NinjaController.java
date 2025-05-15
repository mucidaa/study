package com.mucida.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping
    public String home(){
        return "This is the home page";
    }

    @PostMapping()
    public String addNinja(){
        return "Ninja added";
    }

    @GetMapping()
    public String getAllNinjas(){
        return "All ninjas got";
    }

    @GetMapping("/{id}")
    public String getNinjaById(@PathVariable int id){
        return "Ninja got";
    }

    @PutMapping()
    public String updateNinja(){
        return "Ninja updated";
    }

    @DeleteMapping("/{id}")
    public String deleteNinja(@PathVariable int id){
        return "Ninja deleted";
    }

}
