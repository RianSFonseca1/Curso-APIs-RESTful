package com.Curso_APIs_REST.Modulo_5.Domain.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class PersonDTO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String gender;

    private Long age;

}
