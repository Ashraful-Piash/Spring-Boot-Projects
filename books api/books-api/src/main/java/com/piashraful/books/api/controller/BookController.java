package com.piashraful.books.api.controller;

import com.piashraful.books.api.entity.BookEntity;
import com.piashraful.books.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @PostMapping("/book")
//    public BookEntity saveBook(@RequestBody BookEntity bookEntity){
//        return bookService.saveBook(bookEntity);
//    }
    @PostMapping("/book")
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity bookEntity){
        BookEntity savedBook = bookService.saveBook(bookEntity);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);

    }
    @PostMapping("/books")
    public List<BookEntity> saveListOfBooks(@RequestBody List<BookEntity> bookEntityList){
        return bookService.saveListOfBooks(bookEntityList);
    }

    @GetMapping("/books")
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{isbn}")
    public Optional<BookEntity> getBookById(@PathVariable("isbn") String isbn){

        return bookService.getBookById(isbn);
    }
    @PutMapping("/book/{isbn}")
    public Optional<BookEntity>updateBookById(@PathVariable("isbn") String isbn, @RequestBody BookEntity updatedBookEntity){
        return bookService.updateBookById(isbn,updatedBookEntity);

    }

    @DeleteMapping("/book/{isbn}")
    public void deleteBookById(@PathVariable("isbn") String isbn){
         bookService.deleteBookById(isbn);
    }

}
