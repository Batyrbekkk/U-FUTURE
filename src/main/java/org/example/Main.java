package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Search Book by Author");
        System.out.println("5. Search Book by Year");
        System.out.println("6. Display All Books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, year, isbn));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    library.removeBook(isbn);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    List<Book> booksByTitle = library.searchByTitle(title);
                    booksByTitle.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    List<Book> booksByAuthor = library.searchByAuthor(author);
                    booksByAuthor.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter year to search: ");
                    year = scanner.nextInt();
                    List<Book> booksByYear = library.searchByYear(year);
                    booksByYear.forEach(System.out::println);
                    break;
                case 6:
                    List<Book> allBooks = library.getAllBooks();
                    allBooks.forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
}
//        public static void bubbleSort(int[] array) {
//
//        int n = array.length;
//        boolean swapped;
//
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < n - 1 - i; j++) {
//                if (array[j] > array[j + 1]) {
//                    // Меняем элементы местами
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                    swapped =  true;
//                }
//            }
//            // Если во внутреннем цикле не было обменов, то массив уже отсортирован
//            if (!swapped) {
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] array = {64, 34, 25, 12, 22, 11, 90};
//        System.out.println("Исходный массив:");
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        bubbleSort(array);
//
//        System.out.println("Отсортированный массив:");
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//    }
//}