package br.com.erudio.restwithspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.converter.DozerConverter;
import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.exception.ResourceNotFoundException;
import br.com.erudio.restwithspringboot.repository.PersonRepository;
import br.com.erudio.restwithspringboot.vo.PersonVO;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class); 
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class); 
		return vo;
		
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObject(personRepository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		var entity =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		var entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		personRepository.delete(entity);

	}

}
