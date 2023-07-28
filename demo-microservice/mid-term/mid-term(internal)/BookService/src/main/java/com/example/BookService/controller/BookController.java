package com.example.BookService.controller;

import com.example.BookService.model.BookModel;
import com.example.BookService.model.BookResponseModel;
import com.example.BookService.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book-service")
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public void createBook(@RequestBody BookModel bookModel) {
        bookService.createBook(bookModel);
    }


    @GetMapping("/book/all")
    public ResponseEntity<List<BookResponseModel>> getAllBook() {
        List<BookResponseModel> bookResponseModel = bookService.getAllBook();
        return ResponseEntity.ok(bookResponseModel);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponseModel> getBook(@PathVariable("id") Long bookId) {
        BookResponseModel bookResponseModel = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookResponseModel);
    }

    @PutMapping("/update")
    public ResponseEntity<BookModel> updateBook(@RequestBody BookModel bookModel) {
        bookService.updateBook(bookModel);

        return ResponseEntity.ok(bookModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
