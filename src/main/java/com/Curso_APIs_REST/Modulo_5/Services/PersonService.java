package com.Curso_APIs_REST.Modulo_5.Services;

import com.Curso_APIs_REST.Modulo_5.Model.Person;
import com.Curso_APIs_REST.Modulo_5.Model.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto create(PersonDto personDto);
    PersonDto update(Long id, PersonDto personDto);
    PersonDto findById(Long id);
    List<PersonDto> findAll();
    String delete(Long id);

    /*
    PersonDto addPerson(PersonDto personDto);
    PersonDto findById(String id);
    List<PersonDto> findAll();
     */
}
