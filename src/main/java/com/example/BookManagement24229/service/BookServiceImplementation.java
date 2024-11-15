package com.example.BookManagement24229.service;

import com.example.BookManagement24229.dao.BookDao;
import com.example.BookManagement24229.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookServiceInterface{

    @Autowired
    private BookDao bookDao;
    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book findBookByTitle(String titleName) {
        Book book = bookDao.findByTitle(titleName);
        return book;
    }

    @Override
    public Book findBookById(Integer bookId) {
        Book book = bookDao.findById(bookId).orElse(null);
        if (book == null) {
            return null;
        } else {
            return book;
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book updateAuthorInformation(
            Integer bookId, String authorFName,
            String authorLName, String authorMail)  {
        Book book = bookDao.findById(bookId).orElse(null);
        if (book != null) {
            book.setAuthorFirstName(authorFName);
            book.setAuthorLastName(authorLName);
            book.setAuthorEmail(authorMail);
            return bookDao.save(book);
        } else{
            return null;
        }
    }

    @Override
    public boolean deleteBookById(Integer bookId) {
        Book book = bookDao.findById(bookId).orElse(null);
        if (book != null) {
            bookDao.delete(book);
            return true;
        }
        return false;
    }


}
