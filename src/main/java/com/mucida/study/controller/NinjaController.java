package com.mucida.study.controller;

import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um novo ninja", description = "Cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso")
    })
    public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninja){
        ninjaService.addNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping()
    @Operation(summary = "Lista os ninjas", description = "Rota lista os ninjas salvos no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas retornados"),
    })
    public ResponseEntity<List<NinjaDTO>> getAllNinjas(){
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.getAllNinjas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<NinjaDTO> getNinjaById(@PathVariable Long id){
        if (ninjaService.getNinjaById(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninjaService.getNinjaById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<NinjaDTO> updateNinja(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisiçao")
            @RequestBody NinjaDTO ninja){
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
