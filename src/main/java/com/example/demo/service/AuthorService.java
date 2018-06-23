package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorsRepository;

@Service
public class AuthorService {

	@Autowired
	public AuthorsRepository authorRepository;

	// save new author
	public Author saveNewAuthor(Author author) {

		return authorRepository.save(author);
	}

	// get all authors
	public List<Author> getAuthorList() {
		return authorRepository.findAll();
	}

	// update author using author id
	public Author updateAuthor(Integer authorId, Author authorRequest) {
		return authorRepository.findById(authorId).map(author -> {
			author.setAuthorName(authorRequest.getAuthorName());
			author.setNoOfBookPublished(authorRequest.getNoOfBookPublished());
			return authorRepository.save(author);
		}).orElseThrow(() -> new ResourceNotFoundException("Author " + authorId + " not found"));
	}

	public ResponseEntity<Object> deleteAuthor(Integer authorId) {

		return authorRepository.findById(authorId).map(author -> {
			authorRepository.delete(author);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Author " + authorId + " not found"));
	}

}
