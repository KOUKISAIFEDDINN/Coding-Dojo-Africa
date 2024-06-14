package com.auth.loginandregistration.services;

import com.auth.loginandregistration.models.Book;
import com.auth.loginandregistration.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book b){
        return bookRepository.save(b);
    }

    public Book findBookById(Long id) {
        Optional<Book> maybeBook = bookRepository.findById(id);
        return maybeBook.orElse(null);
    }

//    Update
    public Book updateBook(Book b){
        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
