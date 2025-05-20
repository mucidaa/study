package com.mucida.study.controller;

import com.mucida.study.model.NinjaModel;
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
    public List<NinjaModel> getAllNinjas(){
        return ninjaService.getAllNinjas();
    }

    @GetMapping("/{id}")
    public NinjaModel getNinjaById(@PathVariable Long id){
        return ninjaService.getNinjaById(id);
    }

    @PutMapping("/{id}")
    public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.updateNinja(id, ninja);
    }

    @DeleteMapping("/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }

}
