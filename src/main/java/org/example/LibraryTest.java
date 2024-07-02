package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", 2001, "ISBN1");
        book2 = new Book("Title2", "Author2", 2002, "ISBN2");
        book3 = new Book("Title3", "Author1", 2003, "ISBN3");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void testAddBook() {
        Book book4 = new Book("Title4", "Author4", 2004, "ISBN4");
        library.addBook(book4);
        assertEquals(4, library.getAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN1");
        assertEquals(2, library.getAllBooks().size());
        assertFalse(library.getAllBooks().contains(book1));
    }

    @Test
    public void testSearchByTitle() {
        List<Book> result = library.searchByTitle("Title1");
        assertEquals(1, result.size());
        assertEquals(book1, result.get(0));
    }

    @Test
    public void testSearchByAuthor() {
        List<Book> result = library.searchByAuthor("Author1");
        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book3));
    }

    @Test
    public void testSearchByYear() {
        List<Book> result = library.searchByYear(2002);
        assertEquals(1, result.size());
        assertEquals(book2, result.get(0));
    }

    @Test
    public void testGetAllBooks() {
        List<Book> result = library.getAllBooks();
        assertEquals(3, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        assertTrue(result.contains(book3));
    }
}