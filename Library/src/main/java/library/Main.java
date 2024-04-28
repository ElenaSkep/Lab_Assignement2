package library;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static LibraryFunctions library = new LibraryFunctions();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the Book Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. View all books");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    library.addBook(title, author, price);
                    
                    break; 
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    library.updateBook(idToUpdate, newTitle, newAuthor, newPrice);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    library.deleteBook(idToDelete);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayAllBooks() {
        List<Book> books = library.getAllBooks();
        System.out.println("\nList of Books:");
        for (Book book : books) {
            System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
        }
    }
}
