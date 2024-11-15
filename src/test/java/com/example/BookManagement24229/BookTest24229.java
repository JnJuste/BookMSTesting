package com.example.BookManagement24229;


import com.example.BookManagement24229.service.BookServiceInterface;
import com.example.BookManagement24229.model.Book;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest24229 {

    @Autowired
    private BookServiceInterface bookServiceInterface;

    //Testing for create a book
    @Test
    @Order(1)
    public void testBook(){
        Book livre = new Book();
        livre.setId(1);
        livre.setTitle("Bakame");
        livre.setAuthorFirstName("Jaja");
        livre.setAuthorLastName("Juste");
        livre.setAuthorEmail("jajuste@gmail.com");

        Book book = bookServiceInterface.saveBook(livre);
        assertNotNull(book);
    }

    //Test find a book by title
    @Test
    @Order(2)
    public void testFindBookByTitle() {
        Book book = bookServiceInterface.findBookByTitle("Bakame");

        assertEquals("Bakame", book.getTitle());
    }

    //Test get all the books
    @Test
    @Order(3)
    public void testFindAllBooks() {
        List<Book> books = bookServiceInterface.findAllBooks();

        assertEquals(1, books.size());
    }

    // Test update a book author information
    @Test
    @Order(4)
    public void testUpdateAuthorInformation() {
        Book updateBook = bookServiceInterface.updateAuthorInformation(1, "Samandari", "IRAKOZE", "samira@gmail.com");
        assertEquals("Samandari", updateBook.getAuthorFirstName());
        assertEquals("IRAKOZE", updateBook.getAuthorLastName());
        assertEquals("samira@gmail.com", updateBook.getAuthorEmail());
    }

    //Test delete a book
    @Test
    @Order(5)
    public void testDeleteBook() {
        bookServiceInterface.deleteBookById(1);
        Book book = bookServiceInterface.findBookByTitle("Bakame");

        assertNull(book);
    }

}
