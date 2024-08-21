package com.Curso_APIs_REST.Modulo_5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDto {

    private String firstName;
    private String lastName;
    private String adress;
    private String gender;
}
