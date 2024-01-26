package com.w2m.heroes.controller;

import com.w2m.heroes.persistence.entity.Heroe;
import com.w2m.heroes.services.HeroeService;
import com.w2m.heroes.services.dto.HeroeInDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/heroes")
public class HeroeController {
    private final HeroeService heroeService;
    private static Logger logger = LoggerFactory.getLogger(HeroeController.class);

    public HeroeController(HeroeService heroeService) {
        this.heroeService = heroeService;
    }


    @PostMapping
    public Heroe createHeroe(@RequestBody HeroeInDTO heroeInDTO){
        return this.heroeService.createHeroe(heroeInDTO);

    }

     @GetMapping
    public List<Heroe> findAll(){
        return this.heroeService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Heroe> findByName(@PathVariable("name") String name){
        return this.heroeService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Heroe findById(@PathVariable("id") Long id){
        return this.heroeService.findById(id);
    }


    @PatchMapping("/modificar/{id}&{name}&{campo1}&{campo2}&{campo3}")
    public ResponseEntity<Void> updateHeroe(@PathVariable("id") Long id,
                                            @PathVariable("name") String name,
                                            @PathVariable("campo1") String campo1,
                                            @PathVariable("campo2") String campo2,
                                            @PathVariable("campo3") String campo3) {

        this.heroeService.updateHeroe(id, name, campo1, campo2, campo3);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.heroeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}