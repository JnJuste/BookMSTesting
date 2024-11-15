package com.example.BookManagement24229.dao;

import com.example.BookManagement24229.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {
    Book findByTitle(String titleName);
}
