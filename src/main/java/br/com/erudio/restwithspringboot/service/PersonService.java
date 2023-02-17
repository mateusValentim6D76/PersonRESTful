package br.com.erudio.restwithspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.github.dozermapper.core.DozerBeanMapper;

import br.com.erudio.restwithspringboot.controller.PersonController;
import br.com.erudio.restwithspringboot.converter.DozerConverter;
import br.com.erudio.restwithspringboot.converter.custom.PersonConverter;
import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.exception.ResourceNotFoundException;
import br.com.erudio.restwithspringboot.repository.PersonRepository;
import br.com.erudio.restwithspringboot.vo.v1.PersonVO;
import br.com.erudio.restwithspringboot.vo.v2.PersonVOV2;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonConverter converter;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;

	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVoToEntity(person);
		var vo = converter.convertEntityToVo(personRepository.save(entity));
		return vo;

	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObject(personRepository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		PersonVO vo = DozerConverter.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public PersonVO update(PersonVO person) {
		var entity = personRepository.findById(person.getKey())
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
