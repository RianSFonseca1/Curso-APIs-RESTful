package com.Curso_APIs_REST.Modulo_5.Mapper;


import com.Curso_APIs_REST.Modulo_5.Domain.DTO.PersonDTO;
import com.Curso_APIs_REST.Modulo_5.Domain.Entity.Person;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    @Mapping(target = "age", expression = "java(ageCalculation(person.getBirthDate()))")
    public abstract PersonDTO personToPersonDto(Person person);

    public abstract Person personDtoToPerson(PersonDTO personDto);

    public Long ageCalculation(LocalDate birthDate) {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
