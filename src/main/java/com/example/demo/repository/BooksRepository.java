package com.example.demo.repository;

import com.example.demo.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

	//Page<Book> findByAuthorId(Integer authorId, Pageable pageable);

	Page<Book> findByAuthorAuthorId(Integer authorId, Pageable pageable);
}
