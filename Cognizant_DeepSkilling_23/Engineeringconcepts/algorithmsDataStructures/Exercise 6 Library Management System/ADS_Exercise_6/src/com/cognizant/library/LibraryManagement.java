package com.cognizant.library;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0)
                return books[mid];

            else if (result < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C", "Dennis Ritchie"),
                new Book(104, "Data Structures", "Mark Allen")
        };

        System.out.println("Linear Search:");

        Book result1 = linearSearch(books, "Python");

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Book Not Found.");

        // Sort before Binary Search
        Arrays.sort(books, Comparator.comparing(book -> book.title));

        System.out.println("\nBooks After Sorting:");

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nBinary Search:");

        Book result2 = binarySearch(books, "Python");

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Book Not Found.");
    }
}