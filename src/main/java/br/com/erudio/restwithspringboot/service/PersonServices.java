package br.com.erudio.restwithspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.exception.ResourceNotFoundException;
import br.com.erudio.restwithspringboot.model.Person;
import br.com.erudio.restwithspringboot.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person findById(Long id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person update(Person p) {

		Person personEntity = personRepository.findById(p.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personEntity.setFirstName(p.getFirstName());
		personEntity.setLastName(p.getLastName());
		personEntity.setAddress(p.getAddress());
		personEntity.setGender(p.getGender());
		return personRepository.save(personEntity);
	}

	public void delete(Long id) {
		Person personEntity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		personRepository.delete(personEntity);
		
	}

}
