package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.Book.Books;
import com.example.demospringsecurity.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @RequestMapping(path = {"/",""})
    public void apiNotFound(){
        throw new IllegalStateException("You have enter wrong API");
    }
    @GetMapping("/view")
    public List<Books> getAllBooks(){
        System.out.println("getAllBooks");
        return booksService.getBooks();
    }
    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        booksService.deleteBooks(bookId);
    }
//    @PutMapping("/{bookId}")
//    public void updateStudent(@PathVariable("bookId") Long bookId, @RequestParam(required = false) int price) {
//        booksService.updateBooks(bookId, price);
//    }
    @PutMapping("/update/{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId, @RequestBody Books book) {
        booksService.updateBook(bookId, book);
    }
    @PostMapping("/post")
    public void addBook(@RequestBody Books book) {
//        try{
//            this.cloudinary.uploader().upload(student.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
////            String img = (String) r.get("secure_url");
////            System.out.println(img);
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
        booksService.addNewBook(book);
    }

}
