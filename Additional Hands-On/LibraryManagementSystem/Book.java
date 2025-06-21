package LibraryManagementSystem;

import java.util.Arrays;

public class Book {
    private int bookId;
    private String title;
    private String author;

    private static Book[] books;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    private void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }

    public static void linearSearch(String searchTitle) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Book Found (Linear Search):");
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found using Linear Search.");
        }
    }

    public static void binarySearch(String searchTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int result = books[mid].title.compareToIgnoreCase(searchTitle);
            if (result == 0) {
                System.out.println("Book Found (Binary Search):");
                books[mid].display();
                return;
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found using Binary Search.");
    }

    public static void sortBooksByTitle() {
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));
    }

    public static void main(String[] args) {
        books = new Book[] {
            new Book(101, "Java Basics", "Amit Sharma"),
            new Book(102, "Data Structures", "Priya Verma"),
            new Book(103, "Web Development", "Nikhil Sinha"),
            new Book(104, "Algorithms", "Anita Roy")
        };

        System.out.println("Searching 'Web Development' using Linear Search:");
        linearSearch("Web Development");

        System.out.println("\nSearching 'Algorithms' using Binary Search:");
        sortBooksByTitle(); 
        binarySearch("Algorithms");

        System.out.println("\nTrying Binary Search on a book not in list:");
        binarySearch("Python Programming");
    }
}

