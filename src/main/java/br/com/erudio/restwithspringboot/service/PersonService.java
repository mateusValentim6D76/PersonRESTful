package br.com.erudio.restwithspringboot.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.controller.PersonController;
import br.com.erudio.restwithspringboot.converter.DozerConverter;
import br.com.erudio.restwithspringboot.converter.custom.PersonConverter;
import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.exception.RequiredObjectIsNullException;
import br.com.erudio.restwithspringboot.exception.ResourceNotFoundException;
import br.com.erudio.restwithspringboot.repository.PersonRepository;
import br.com.erudio.restwithspringboot.vo.v1.PersonVOV1;
import br.com.erudio.restwithspringboot.vo.v2.PersonVOV2;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PagedResourcesAssembler<PersonVOV1> assembler;
	@Autowired
	private PersonConverter converter;

	public PersonVOV1 create(PersonVOV1 person) {
		if (person == null)
			throw new RequiredObjectIsNullException();
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVOV1.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;

	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVoToEntity(person);
		var vo = converter.convertEntityToVo(personRepository.save(entity));
		return vo;
	}

	public PagedModel<EntityModel<PersonVOV1>> findAll(Pageable pageable) {

		var personPage = personRepository.findAll(pageable);
		var personVOPage = personPage.map(personEntity -> DozerConverter.parseObject(personEntity, PersonVOV1.class));

		personVOPage.map(personEntity -> personEntity
				.add(linkTo(methodOn(PersonController.class).findById(personEntity.getKey())).withSelfRel()));

		Link link = linkTo(
				methodOn(PersonController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc"))
						.withSelfRel();

		return assembler.toModel(personVOPage, link);
	}

	public PagedModel<EntityModel<PersonVOV1>> findPersonsByName(String firstName, Pageable pageable) {

		var personPage = personRepository.findPersonsByName(firstName, pageable);
		var personVOPage = personPage.map(personEntity -> DozerConverter.parseObject(personEntity, PersonVOV1.class));

		personVOPage.map(personEntity -> personEntity
				.add(linkTo(methodOn(PersonController.class).findById(personEntity.getKey())).withSelfRel()));

		Link link = linkTo(
				methodOn(PersonController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc"))
						.withSelfRel();

		return assembler.toModel(personVOPage, link);
	}

	public PersonVOV1 findById(Long id) {
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		var vo = DozerConverter.parseObject(entity, PersonVOV1.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public PersonVOV1 update(PersonVOV1 person) {
		if (person == null)
			throw new RequiredObjectIsNullException();

		var entity = personRepository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVOV1.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	@Transactional
	public PersonVOV1 disablePerson(Long id) {
		personRepository.disablePerson(id);
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		var vo = DozerConverter.parseObject(entity, PersonVOV1.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public void delete(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID " + id));
		personRepository.delete(entity);

	}

}
