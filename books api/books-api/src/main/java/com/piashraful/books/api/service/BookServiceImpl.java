package com.piashraful.books.api.service;

import com.piashraful.books.api.entity.BookEntity;
import com.piashraful.books.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity saveBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> saveListOfBooks(List<BookEntity> bookEntityList) {
        return bookRepository.saveAll(bookEntityList);
    }

    @Override
    public Optional<BookEntity> getBookById(String isbn) {

        Optional<BookEntity> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isEmpty()) {
            String message = "NO book found with isbn number :" + isbn;
            BookEntity notBookFound = new BookEntity(message, "Null", "Null");
            return Optional.of(notBookFound);

        } else {
            return bookOptional;
        }
    }

    @Override
    public Optional<BookEntity> updateBookById(String isbn, BookEntity updatedBookEntity) {
        Optional<BookEntity> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isEmpty()) {
            String message = "NO book found with isbn number :" + isbn;
            BookEntity notBookFound = new BookEntity(message, "Null", "Null");
            return Optional.of(notBookFound);
        } else {
            BookEntity existingBook = bookOptional.get();
            existingBook.setAuthor(updatedBookEntity.getAuthor());
            existingBook.setTitle(updatedBookEntity.getTitle());
            BookEntity savedBook = bookRepository.save(existingBook);
            return Optional.of(savedBook);
        }
    }

    @Override
    public void deleteBookById(String isbn) {
        Optional<BookEntity> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isEmpty()) {
            String message = "NO book found with isbn number :" + isbn;
            System.out.println(message);
        } else {
            System.out.println("Book with isbn No" +isbn +" deleted successfully");
            bookRepository.deleteById(isbn);
        }
    }
}
