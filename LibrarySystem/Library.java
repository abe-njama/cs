import java.util.HashMap;// Import the HashMap for storing the book collection
import java.util.Map;// Import the Map class for managing the book collection
import java.util.Scanner;// Import the Scanner class for user input

/**
 *  Compilation:  javac Library.java
 *  Execution:    java Library
 * 
 * This is a library system that allows users to query for a list of all the books available in the library,
 * add books, borrow books and return books.
 */

public class Library {
    private static Map<String, Book> library = new HashMap<>();
    // Map to store the library's books with their titles as keys

    private static Scanner scanner = new Scanner(System.in);
    // Scanner object for reading user input
    

    /**
     * This is the main method that runs the library system.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Digital Library!");
        int input;

        do {
            System.out.println("Select one of the options below by typing in the number next to your preferred task:");
            System.out.println("1. Show list of all books");
            System.out.println("2. Add books");
            System.out.println("3. Borrow books");
            System.out.println("4. Return books");
            System.out.println("5. Exit");
            // Displays the menu options to the user

            input = scanner.nextInt();// Get the user input
            scanner.nextLine(); // Consume the newline character

            // Using a switch-case statement to handle user input
            switch (input) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    addBooks();
                    break;
                case 3:
                    borrowBooks();
                    break;
                case 4:
                    returnBooks();
                    break;
                case 5:
                    System.out.println("Thank you for using the Digital Library.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } while (input != 5);// Continue until the user chooses to exit

        scanner.close();// Close the scanner object
    }

    /**
     * List all the books in the library.
     */
    private static void listAllBooks() {
        if (library.isEmpty()) {
            System.out.println("The library is currently out of books.");
        } else {
            for (Book book : library.values()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " => Quantity: " + book.getQuantity());
            }
        }
    }

    /**
     * Add new books to the library or increase the quantity of existing books based on user input.
     */
    private static void addBooks() {
        System.out.println("Type in the title of the book:");
        String title = scanner.nextLine();
        System.out.println("Type in the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Type in the number of books:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book book = library.get(title);
        if (book != null) {
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Book count has been increased in the library.");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book has been added to the library.");
        }
    }

    /**
     * Borrow books from the library.
     */
    private static void borrowBooks() {
        System.out.print("Type in the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Type in the number of books to borrow: ");
        int quantityToBorrow = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book book = library.get(title);
        if (book != null && book.getQuantity() >= quantityToBorrow) {
            book.setQuantity(book.getQuantity() - quantityToBorrow);
            System.out.println("Borrowing request is Approved!");
        } else {
            System.out.println("The book is not available.");
        }
    }

    /**
     * Return books to the library.
     */
    private static void returnBooks() {
        System.out.print("Type in the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Type in the number of books to return: ");
        int quantityToReturn = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book book = library.get(title);
        if (book != null && (book.getQuantity() + quantityToReturn) <= book.getInitialQuantity()) {
            book.setQuantity(book.getQuantity() + quantityToReturn);
            System.out.println("Book is successfully returned!");
        } else if (book != null) {
            System.out.println("You are trying to return more books than were added. Return rejected.");
        } else {
            System.out.println("This book does not belong to this library.");
        }
    }

    /**
     * A class representing a book in the library.
     */
    private static class Book {
        private String title;
        private String author;
        private int quantity;
        private int initialQuantity;

        /**
         * Constructs a new Book with the specified title, author, and quantity.
         */
        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
            this.initialQuantity = quantity;
        }

        /**
         * Gets the title of the book.
         */
        public String getTitle() {
            return title;
        }

        /**
         * Gets the author of the book.
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Gets the quantity of the book.
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Gets the initial quantity of the book added to the library.
         */
        public int getInitialQuantity() {
            return initialQuantity;
        }

        /**
         * Sets the quantity of the book.
         */
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
