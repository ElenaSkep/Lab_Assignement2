package library;

import java.util.ArrayList;
import java.util.List;

public class LibraryFunctions {
    
	private List<Book> books;
    private int nextId;

    public LibraryFunctions() {
        this.books = new ArrayList<>();
        this.nextId = 1; // Initialize nextId for auto-incrementing book IDs
    }

    // Create operation: Add a new book
    public void addBook(String title, String author, double price) {
        Book newBook = new Book(nextId, title, author, price);
        books.add(newBook);
        nextId++; // Increment nextId for the next book
        System.out.println("Book added successfully: " + newBook.getTitle());
    }

    // Read operation: Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Update operation: Update book details
    public void updateBook(int id, String title, String author, double price) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                System.out.println("Book updated successfully: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found with ID: " + id);
    }

    // Delete operation: Delete a book by ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book deleted successfully with ID: " + id);
    }
}
