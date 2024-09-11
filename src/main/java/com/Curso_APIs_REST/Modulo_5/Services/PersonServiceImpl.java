package com.Curso_APIs_REST.Modulo_5.Services;

import com.Curso_APIs_REST.Modulo_5.Domain.Entity.Person;
import com.Curso_APIs_REST.Modulo_5.Domain.DTO.PersonDTO;
import com.Curso_APIs_REST.Modulo_5.Mapper.PersonMapper;
import com.Curso_APIs_REST.Modulo_5.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonDTO create(PersonDTO personDto){
        Person person = personRepository.save(personMapper.personDtoToPerson(personDto));
        return personMapper.personToPersonDto(person);
    }

    @Override
    public PersonDTO findPerson(Long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            return personMapper.personToPersonDto(person.get());
        }
        return null;
    }

    @Override
    public PersonDTO update(PersonDTO personDto){
        if (personRepository.findById(personDto.getId()).isPresent()){
            return create(personDto);
        }
        return null;
    }

    @Override
    public List<PersonDTO> findAll(){
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : personRepository.findAll()){
            personDTOList.add(personMapper.personToPersonDto(person));
        }
        return personDTOList;
    }

    @Override
    public void delete(Long id){
        if (personRepository.findById(id).isPresent()){
            personRepository.deleteById(id);
        }
    }

}
