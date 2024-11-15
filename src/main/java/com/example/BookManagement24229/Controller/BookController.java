package com.example.BookManagement24229.Controller;

import com.example.BookManagement24229.model.Book;
import com.example.BookManagement24229.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/id")
public class BookController {

    //Post Method
    @Autowired
    private BookServiceInterface bookServiceInterface;

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(
            @RequestBody Book book) {
        Book savedBook = bookServiceInterface.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    //Get Method
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookServiceInterface.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //PUT Method
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId, @RequestBody Book book) {
        Book existingBook = bookServiceInterface.findBookById(bookId);
        if(existingBook != null){
            Book updatedBook = new Book();
            updatedBook.setId(bookId);
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthorFirstName(book.getAuthorFirstName());
            updatedBook.setAuthorLastName(book.getAuthorLastName());
            updatedBook.setAuthorEmail(book.getAuthorEmail());
            return new ResponseEntity<>(bookServiceInterface.saveBook(updatedBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //DELETE Method( Delete a Book by ID)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") Integer id) {
        try {
            bookServiceInterface.deleteBookById(Integer.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Negative Tests
    @PostMapping("/negativeSave")
    public Book NegAddBook(@RequestBody Book book){
        return bookServiceInterface.saveBook(book);
    }

}
