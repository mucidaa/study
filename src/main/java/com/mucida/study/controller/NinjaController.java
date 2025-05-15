package com.mucida.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping
    public String home(){
        return "This is the home page";
    }

    @PostMapping("/ninjas")
    public String addNinja(){
        return "Ninja added";
    }

    @GetMapping("/ninjas")
    public String getAllNinjas(){
        return "All ninjas got";
    }

    @GetMapping("/ninjas/{id}")
    public String getNinjaById(@PathVariable int id){
        return "Ninja got";
    }

    @PutMapping("/ninjas")
    public String updateNinja(){
        return "Ninja updated";
    }

    @DeleteMapping("/ninjas/{id}")
    public String deleteNinja(@PathVariable int id){
        return "Ninja deleted";
    }

}
