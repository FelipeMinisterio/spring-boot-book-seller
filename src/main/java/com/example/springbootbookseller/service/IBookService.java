package com.example.springbootbookseller.service;

import java.util.List;

import com.example.springbootbookseller.model.Book;

public interface IBookService {

	Book saveBook(Book book);

	void deleteBook(Long id);

	List<Book> findAllBooks();

}
