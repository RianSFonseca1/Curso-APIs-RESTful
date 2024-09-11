package com.Curso_APIs_REST.Modulo_5.Repository;

import com.Curso_APIs_REST.Modulo_5.Domain.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
