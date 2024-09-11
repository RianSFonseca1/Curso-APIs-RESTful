package com.Curso_APIs_REST.Modulo_5.Controller;

import com.Curso_APIs_REST.Modulo_5.Domain.DTO.PersonDTO;
import com.Curso_APIs_REST.Modulo_5.Services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public PersonDTO create(@RequestBody @Valid PersonDTO personDto){
        return personService.create(personDto);
    }

    @GetMapping("/findAll")
    public List<PersonDTO> findAll(){
        return personService.findAll();
    }

    @GetMapping("/findPerson/{id}")
    public PersonDTO findPerson(@PathVariable Long id){
        return personService.findPerson(id);
    }

    @PutMapping("/update")
    public PersonDTO update(@RequestBody @Valid PersonDTO personDto){
        return personService.update(personDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }


}
