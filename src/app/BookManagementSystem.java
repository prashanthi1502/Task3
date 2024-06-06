package app;
import java.util.Scanner;

class Book{

private int bookID;
private String title;
private String author;
private boolean isAvailable;

    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


public int getBookID() {
    return bookID;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}

public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
}

@Override
public String toString() {
    return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;

}
}
class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        this.books = new Book[5];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(int bookID, String newTitle, String newAuthor) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
            for(Book book : books){
                System.out.println(book);
        }
    }
}
public class BookManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Replace Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Enter title: ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    Book book = new Book(bookID, title, author, true);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int removeID = scanner.nextInt();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.next();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.next();
                    library.removeBook(removeID, newTitle, newAuthor);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}





