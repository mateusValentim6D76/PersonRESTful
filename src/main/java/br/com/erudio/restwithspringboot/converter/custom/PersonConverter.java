package br.com.erudio.restwithspringboot.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.data.model.Person;
import br.com.erudio.restwithspringboot.vo.v2.PersonVOV2;

@Service
public class PersonConverter {

	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDate(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}
}
