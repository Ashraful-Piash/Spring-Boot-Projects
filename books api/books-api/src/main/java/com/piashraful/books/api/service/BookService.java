package com.piashraful.books.api.service;

import com.piashraful.books.api.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

   public List<BookEntity> getAllBooks();

    public BookEntity saveBook(BookEntity bookEntity);

   public List<BookEntity> saveListOfBooks(List<BookEntity> bookEntityList);

   public Optional<BookEntity> getBookById(String isbn);

    public Optional<BookEntity> updateBookById(String isbn, BookEntity updatedBookEntity);

   public void deleteBookById(String isbn);
}
