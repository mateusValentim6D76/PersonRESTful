package br.com.erudio.restwithspringboot.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Mateus");
		person.setLastName("Valentim");
		person.setAddress("Osasco - São Paulo");
		person.setGender("Male");
		return person ;
	}
	
}
