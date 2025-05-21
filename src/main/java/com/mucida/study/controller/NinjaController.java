package com.mucida.study.controller;

import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninja){
        ninjaService.addNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<NinjaDTO>> getAllNinjas(){
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.getAllNinjas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> getNinjaById(@PathVariable Long id){
        if (ninjaService.getNinjaById(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninjaService.getNinjaById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaDTO> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        if (ninjaService.getNinjaById(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninjaService.updateNinja(id, ninja));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id){
        if (ninjaService.getNinjaById(id) != null){
            ninjaService.deleteNinja(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
