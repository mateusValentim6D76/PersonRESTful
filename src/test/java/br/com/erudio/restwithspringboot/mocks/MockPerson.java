package br.com.erudio.restwithspringboot.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.vo.v1.PersonVOV1;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(0);
	}

	public Person mockVO() {
		return mockEntity(0);
	}

	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}

	public List<Person> mockVOList() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}

	public Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Addres Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setGender(((number % 2) == 0) ? "Male" : "Female");
		person.setId(number.longValue());
		person.setLastName("Last Name Test" + number);
		return person;
	}

	public PersonVOV1 mockVO(Integer number) {
		PersonVOV1 person = new PersonVOV1();
		person.setAddress("Addres Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setGender(((number % 2) == 0) ? "Male" : "Female");
		person.setKey(number.longValue());
		person.setLastName("Last Name Test" + number);
		return person;
	}
}
