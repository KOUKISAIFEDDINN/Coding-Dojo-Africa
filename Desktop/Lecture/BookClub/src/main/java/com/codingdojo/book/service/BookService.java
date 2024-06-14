package com.codingdojo.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.book.entity.Book;
import com.codingdojo.book.reposiotry.BookRepository;

@Service
public class BookService {
@Autowired
BookRepository bookRepo;

	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	public List<Book> getAllBook(){
		return bookRepo.findAll();
	}
	
	public Book findOne(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isEmpty()) {
			return null;
		}
		return book.get();
	}
	public Book updateBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
