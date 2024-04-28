package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFunctions {

    private LibraryFunctions library;

    @Before
    public void setUp() {
        library = new LibraryFunctions();
        // Adding some initial books for testing
        library.addBook("Book 1", "Author 1", 20.0);
        library.addBook("Book 2", "Author 2", 25.0);
        library.addBook("Book 3", "Author 3", 30.0);
    }

    @Test
    public void testAddBook() {
        int initialSize = library.getAllBooks().size();
        library.addBook("New Book", "New Author", 15.0);
        int newSize = library.getAllBooks().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = library.getAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    public void testUpdateBook() {
        library.updateBook(2, "Updated Book", "Updated Author", 35.0);
        Book updatedBook = library.getAllBooks().get(1); // Index 1 because IDs start from 1
        assertEquals("Updated Book", updatedBook.getTitle());
        assertEquals("Updated Author", updatedBook.getAuthor());
        assertEquals(35.0, updatedBook.getPrice(), 0.0);
    }

    @Test
    public void testDeleteBook() {
        int initialSize = library.getAllBooks().size();
        library.deleteBook(2);
        int newSize = library.getAllBooks().size();
        assertEquals(initialSize - 1, newSize);
        assertNull(library.getAllBooks().stream().filter(book -> book.getId() == 2).findFirst().orElse(null));
    }

    @Test
    public void testDeleteBookNotFound() {
        int initialSize = library.getAllBooks().size();
        library.deleteBook(10); // Assuming book with ID 10 does not exist
        int newSize = library.getAllBooks().size();
        assertEquals(initialSize, newSize);
    }
}
