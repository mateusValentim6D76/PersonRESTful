package br.com.erudio.restwithspringboot.unittest.mockito.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.exception.RequiredObjectIsNullException;
import br.com.erudio.restwithspringboot.mocks.MockPerson;
import br.com.erudio.restwithspringboot.repository.PersonRepository;
import br.com.erudio.restwithspringboot.service.PersonService;
import br.com.erudio.restwithspringboot.vo.v1.PersonVOV1;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	MockPerson input;
	@InjectMocks
	private PersonService service;
	@Mock
	private PersonRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("[</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

//	@Test
//	void testFindAll() {
//		List<Person> list = input.mockEntityList();
//	
//		when(repository.findAll()).thenReturn(list);
//
//		var people = service.findAll();
//		assertNotNull(people);
//		assertEquals(14, people.size());
//		
//		var peopleOne = people.get(1);
//		assertNotNull(peopleOne);
//		assertNotNull(peopleOne.getKey());
//		assertNotNull(peopleOne.getLinks());
//		assertTrue(peopleOne.toString().contains("[</api/person/v1/1>;rel=\"self\"]"));
//		assertEquals("Addres Test1", peopleOne.getAddress());
//		assertEquals("First Name Test1", peopleOne.getFirstName());
//		assertEquals("Last Name Test1", peopleOne.getLastName());
//		assertEquals("Female", peopleOne.getGender());
//		
//		var peopleFour = people.get(4);
//		assertNotNull(peopleFour);
//		assertNotNull(peopleFour.getKey());
//		assertNotNull(peopleFour.getLinks());
//		assertTrue(peopleFour.toString().contains("[</api/person/v1/4>;rel=\"self\"]"));
//		assertEquals("Addres Test4", peopleFour.getAddress());
//		assertEquals("First Name Test4", peopleFour.getFirstName());
//		assertEquals("Last Name Test4", peopleFour.getLastName());
//		assertEquals("Male", peopleFour.getGender());
//
//		var peopleSeven = people.get(7);
//		assertNotNull(peopleSeven);
//		assertNotNull(peopleSeven.getKey());
//		assertNotNull(peopleSeven.getLinks());
//		assertTrue(peopleSeven.toString().contains("[</api/person/v1/7>;rel=\"self\"]"));
//		assertEquals("Addres Test7", peopleSeven.getAddress());
//		assertEquals("First Name Test7", peopleSeven.getFirstName());
//		assertEquals("Last Name Test7", peopleSeven.getLastName());
//		assertEquals("Female", peopleSeven.getGender());
//	}

	@Test
	void testCreate() {
		Person entity = input.mockEntity(1);

		Person persisted = entity;
		persisted.setId(1L);

		PersonVOV1 vo = input.mockVO(1);

		when(repository.save(persisted)).thenReturn(persisted);
		var result = service.create(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("[</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());

	}

	@Test
	void testCreateWithNull() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});

		String expectedMessage = "It is not allowed to persist a null object !";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testUpdate() {
		Person entity = input.mockEntity(1);

		Person persisted = entity;
		persisted.setId(1L);

		PersonVOV1 vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);

		var result = service.update(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("[</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testUpdateWithNull() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});

		String expectedMessage = "It is not allowed to persist a null object !";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testDelete() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		service.delete(1L);
	}

}
