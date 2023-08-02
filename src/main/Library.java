package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
    static String openingHours = "9am";
    static String closingHours = "5pm";

    private final String address;

    private final List<Book> books = new ArrayList<>();



    static void printOpeningHours(){
        System.out.print("Libraries are open daily from "+openingHours+" to "+closingHours+".");

    }

    public Library(String address){
        this.address = address;

    }


    public void addBook(Book book){
        this.books.add(book);

    }

    public void printAvailableBooks() {
        if (this.books.isEmpty()){
            System.out.println("No book in catalog ");
        }else { for (Book bk : this.books){
            if (!bk.borrowed){
                System.out.println(bk.title+"\n");
            }

        }}

    }

    private void borrowBook(String title) {
        boolean isBookFound = false;
        for (Book bk : this.books){

            if (bk.title.equals(title) && !bk.borrowed){
                bk.borrowed =true;
                isBookFound =true;
                System.out.println("You successfully borrowed "+title);
            }
        }
        if (!isBookFound){
            System.out.println("Sorry, this book is already borrowed.");
        }

    }
    private void returnBook(String title) {
        for(Book bk : this.books){
            if(bk.title.equals(title)){
                bk.borrowed = false;
                System.out.println("You successfully returned "+title);
            }
        }

    }

    public void printAddress(){
        System.out.println(this.address);

    }



    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }




}