package br.com.erudio.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.restwithspringboot.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
