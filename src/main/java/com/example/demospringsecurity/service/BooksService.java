package com.example.demospringsecurity.service;

import com.example.demospringsecurity.Book.Books;
import com.example.demospringsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getBooks(){
        return bookRepository.findAll();
    }

    public void deleteBooks(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }
    public void addNewBook(Books book) {
        Optional<Books> bookOptional = bookRepository.findBooksByTitle(book.getName());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book title have present in db");
        }
        if(book.getPrice() < 0 || book.getDiscount() < 0 || book.getPages() <= 0){
            throw new IllegalStateException("Book schema can not lower than 0");
        }
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Long bookId, Books bookUpdate) {
        Books book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));

        if(bookUpdate.getPrice() >= 0){
            book.setPrice(bookUpdate.getPrice());
        }else{
            throw new IllegalStateException("Price can't not be lower than 0");
        }
    }
}
