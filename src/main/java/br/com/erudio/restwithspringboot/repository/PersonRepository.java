package br.com.erudio.restwithspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.erudio.restwithspringboot.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Modifying
	@Query("UPDATE Person p SET p.enable = false WHERE p.id =:id")
	void disablePerson(@Param("id") Long id);
	

	@Modifying
	@Query("SELECT p FROM Person p WHERE p.firstName LIKE LOWER (CONCAT ('%',:firstName,'%'))")
	Page<Person> findPersonsByName(@Param("firstName") String firstName);
}
