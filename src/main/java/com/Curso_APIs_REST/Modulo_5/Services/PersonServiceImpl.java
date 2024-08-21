package com.Curso_APIs_REST.Modulo_5.Services;

import com.Curso_APIs_REST.Modulo_5.Model.Person;
import com.Curso_APIs_REST.Modulo_5.Model.PersonDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonService{

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final List<Person> personList = new ArrayList<>();

    @Override
    public PersonDto create(PersonDto personDto){
        logger.info("Adding a Person...");
        Person person = new Person(
                counter.incrementAndGet(),
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getAdress(),
                personDto.getGender());
        personList.add(person);
        return personDto;
    }

    @Override
    public PersonDto update(Long id, PersonDto personDto){
        logger.info("Updating a Person...");
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(personDto.getFirstName());
                person.setLastName(personDto.getLastName());
                person.setAdress(personDto.getAdress());
                person.setGender(personDto.getGender());

                return personDto;
            }
        }
        return null;
    }

    @Override
    public PersonDto findById(Long id){
        logger.info("Finding One Person...");
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return new PersonDto(person.getFirstName(), person.getLastName(), person.getAdress(), person.getGender());
            }
        }
        return null;
    }

    @Override
    public List<PersonDto> findAll(){
        logger.info("Finding All People...");
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personList) {
            personDtoList.add(new PersonDto(person.getFirstName(), person.getLastName(), person.getAdress(), person.getGender()));
        }
        return personDtoList;
    }

    @Override
    public String delete(Long id){
        logger.info("Deleting a Person...");
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                personList.remove(person);
                return "THE PERSON HAS BEEN REMOVED!";
            }
        }
        return "IT WAS NOT POSSIBLE REMOVE THE PERSON";
    }

}
