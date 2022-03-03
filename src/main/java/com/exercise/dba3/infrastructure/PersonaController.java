package com.exercise.dba3.infrastructure;

import com.exercise.dba3.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<PersonaListaOutputDTO> findAll()
    {
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonaOutputDTO> findById(@PathVariable String id)
    {
        return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonaOutputDTO> create(@RequestBody PersonaInputDTO inputDTO)
    {
        return new ResponseEntity<>(personaService.save(inputDTO), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonaOutputDTO> update(@PathVariable String id, @RequestBody PersonaInputDTO inputDTO)
    {
        return new ResponseEntity<>(personaService.update(id,inputDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PersonaOutputDTO> delete(@PathVariable String id)
    {
        return new ResponseEntity<>(personaService.deleteById(id), HttpStatus.OK);
    }
}
