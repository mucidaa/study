package com.mucida.study.controller;

import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping()
    public void addNinja(@RequestBody NinjaDTO ninja){
        ninjaService.addNinja(ninja);
    }

    @GetMapping()
    public List<NinjaDTO> getAllNinjas(){
        return ninjaService.getAllNinjas();
    }

    @GetMapping("/{id}")
    public NinjaDTO getNinjaById(@PathVariable Long id){
        return ninjaService.getNinjaById(id);
    }

    @PutMapping("/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.updateNinja(id, ninja);
    }

    @DeleteMapping("/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }

}
