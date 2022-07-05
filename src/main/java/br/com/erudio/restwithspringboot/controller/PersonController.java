package br.com.erudio.restwithspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringboot.converter.DozerConverter;
import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.repository.PersonRepository;
import br.com.erudio.restwithspringboot.vo.PersonVO;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository repository;

	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	@GetMapping
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), PersonVO.class);
	}

	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id " + id));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	@PutMapping
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id " + id));
		repository.delete(entity);
	}

}
