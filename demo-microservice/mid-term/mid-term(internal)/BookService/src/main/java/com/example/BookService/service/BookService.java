package com.example.BookService.service;

import com.example.BookService.model.BookModel;
import com.example.BookService.model.BookResponseModel;

import java.util.List;

public interface BookService {
    void createBook(BookModel bookModel);

    List<BookResponseModel> getAllBook();
    BookResponseModel getBookById(Long bookId);

    BookModel updateBook(BookModel bookModel);

    void deleteBook(Long bookId);
}
