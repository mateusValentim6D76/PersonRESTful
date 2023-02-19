package br.com.erudio.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.restwithspringboot.data.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
