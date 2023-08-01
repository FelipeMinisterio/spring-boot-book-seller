package com.example.springbootbookseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbookseller.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long>{

	
}
