package br.com.erudio.restwithspringboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringboot.converter.NumberConverter;
import br.com.erudio.restwithspringboot.exception.UnsuportedMathOperationException;
import br.com.erudio.restwithspringboot.math.SimpleMath;
import br.com.erudio.restwithspringboot.model.Person;
import br.com.erudio.restwithspringboot.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id){
		return service.findById(id);
		}	
	}	

