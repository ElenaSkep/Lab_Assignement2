package library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBook {

    @Test
    public void testSetAndGetId() {
        Book book = new Book(1, "Title", "Author", 10.0);
        book.setId(2);
        assertEquals(2, book.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        Book book = new Book(1, "Title", "Author", 10.0);
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testSetAndGetAuthor() {
        Book book = new Book(1, "Title", "Author", 10.0);
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testSetAndGetPrice() {
        Book book = new Book(1, "Title", "Author", 10.0);
        book.setPrice(15.0);
        assertEquals(15.0, book.getPrice(), 0.0);
    }

}

