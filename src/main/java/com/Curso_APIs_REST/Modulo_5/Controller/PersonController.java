package com.Curso_APIs_REST.Modulo_5.Controller;

import com.Curso_APIs_REST.Modulo_5.Model.Person;
import com.Curso_APIs_REST.Modulo_5.Model.PersonDto;
import com.Curso_APIs_REST.Modulo_5.Services.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/create")
    public PersonDto create(@RequestBody PersonDto personDto){
        return personService.create(personDto);
    }

    @GetMapping("/findAll")
    public List<PersonDto> findAll(){
        return personService.findAll();
    }

    @GetMapping("/findById/{id}")
    public PersonDto findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PutMapping("/update/{id}")
    public PersonDto update(@PathVariable Long id, @RequestBody PersonDto personDto){
        return personService.update(id, personDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return personService.delete(id);
    }


}
