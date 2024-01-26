package com.w2m.heroes.services;

import com.w2m.heroes.exceptions.ToDoExceptions;
import com.w2m.heroes.mapper.HeroeInDTOToHeroe;
import com.w2m.heroes.persistence.entity.Heroe;
import com.w2m.heroes.persistence.repository.HeroeRepository;
import com.w2m.heroes.services.dto.HeroeInDTO;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HeroeService {
    private final HeroeRepository repository;
    private final HeroeInDTOToHeroe mapper;

    public HeroeService(HeroeRepository repository, HeroeInDTOToHeroe mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Heroe createHeroe(HeroeInDTO heroeInDTO){
        Heroe heroe = mapper.map(heroeInDTO);
        return this.repository.save(heroe);
    }

    public List<Heroe> findAll() {
        return this.repository.findAll();
    }

    public List<Heroe> findByName(String name) {
        return this.repository.findByName(name);
    }

    public Heroe findById(Long id) {
        //return this.repository.findById(id);
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Heroe no encontrado por id " + id));
    }

    @Transactional
    public void updateHeroe(Long id, String name, String campo1,String campo2, String campo3) {

        Optional<Heroe> optionalHeroe = this.repository.findById(id);
        if (optionalHeroe.isEmpty()) {
            throw new ToDoExceptions("Heroe no encontrado", HttpStatus.NOT_FOUND);
        }

        this.repository.updateHeroe(id, name, campo1, campo2, campo3);
    }

    public void deleteById(Long id) {
        Optional<Heroe> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Heroe no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
