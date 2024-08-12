package com.Curso_APIs_REST.Modulo_5.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
