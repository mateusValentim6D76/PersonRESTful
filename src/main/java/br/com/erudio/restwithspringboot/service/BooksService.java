package br.com.erudio.restwithspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.erudio.restwithspringboot.controller.BooksController;
import br.com.erudio.restwithspringboot.controller.PersonController;
import br.com.erudio.restwithspringboot.converter.DozerConverter;
import br.com.erudio.restwithspringboot.data.model.Books;
import br.com.erudio.restwithspringboot.exception.RequiredObjectIsNullException;
import br.com.erudio.restwithspringboot.repository.BooksRepository;
import br.com.erudio.restwithspringboot.vo.v1.BooksVO;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public BooksVO create(BooksVO books) {
		if(books == null) throw new RequiredObjectIsNullException();
		var entity  = DozerConverter.parseObject(books, Books.class);
		var vo = DozerConverter.parseObject(booksRepository.save(entity), BooksVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public BooksVO findById(Long id) {
		var entity = booksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not records founds for ID"));
		var vo = DozerConverter.parseObject(entity, BooksVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

}
