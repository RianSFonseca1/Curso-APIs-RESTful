package com.Curso_APIs_REST.Modulo_5.Services;

import com.Curso_APIs_REST.Modulo_5.Domain.DTO.PersonDTO;
import com.Curso_APIs_REST.Modulo_5.Domain.Entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    PersonDTO create(PersonDTO personDto);

    PersonDTO update(PersonDTO personDto);

    PersonDTO findPerson(Long id);

    List<PersonDTO> findAll();

    void delete(Long id);

}
