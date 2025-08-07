package com.study;
import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Add book to the collection
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full!");
        }
    }

    // Linear search for books by title
    public void linearSearchByTitle(String title) {
        System.out.println("Linear Search Results for \"" + title + "\":");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title: " + title);
        }
    }

    // Binary search for a book by title (requires sorted array)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title to prepare for binary search
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(b -> b.title.toLowerCase()));
    }

    // Display all books
    public void listBooks() {
        if (count == 0) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("Library Books:");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        // Add books
        library.addBook(new Book(1, "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(4, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(5, "The Hobbit", "J.R.R. Tolkien")); // duplicate title

        // List books
        library.listBooks();

        // Linear search (works on unsorted data)
        library.linearSearchByTitle("The Hobbit");

        // Sort books by title for binary search
        library.sortBooksByTitle();

        System.out.println("\nBooks sorted by title:");
        library.listBooks();

        // Binary search (requires sorted data)
        Book found = library.binarySearchByTitle("1984");
        System.out.println("\nBinary Search Result for '1984':");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Book not found.");
        }

        // Binary search for a non-existent book
        Book notFound = library.binarySearchByTitle("Unknown Title");
        System.out.println("\nBinary Search Result for 'Unknown Title':");
        System.out.println(notFound == null ? "Book not found." : notFound);
    }
}


