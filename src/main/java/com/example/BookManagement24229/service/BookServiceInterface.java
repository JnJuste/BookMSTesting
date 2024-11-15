package com.example.BookManagement24229.service;

import com.example.BookManagement24229.model.Book;

import java.util.List;

public interface BookServiceInterface {
    Book saveBook(Book book);
    Book findBookByTitle(String titleName);
    Book findBookById(Integer bookId);
    List<Book> findAllBooks();
    Book updateAuthorInformation
            (Integer bookId, String authorFName,
             String authorLName, String authorMail);
    boolean deleteBookById(Integer bookId);
}
