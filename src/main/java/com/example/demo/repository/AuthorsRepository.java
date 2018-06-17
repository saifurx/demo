package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {

}
