package ro.homework;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {

    public String title;
    public String author;
    public String page;
    public String status;
    public String kind;

    public int bookChoice;

    static ArrayList<Book> BookList = new ArrayList<Book>();

    static int choice;

    static Scanner userInput = new Scanner(System.in);
    static Scanner choiceInput = new Scanner(System.in);

    public static void displayMenu() {

        System.out.println("\n1- Check the Library book list.");
        System.out.println("2- Add a book to the Library.");
        System.out.println("3- Remove a book from the Library.");
        System.out.println("4- Delete the entire Library.");
        System.out.println("0- Exit.");
        System.out.print("\nEnter your option here: ");
        choice = choiceInput.nextInt();//User inputs a choice.

    }

    public String displayBook() {

        String BookInfo =
                "\n-------------------------------------" +
                "\nTitle:........................" + title +
                "\nAuthor:......................." + author +
                "\nNumber of Pages:.............." + page +
                "\nKind:........................." + kind +
                "\n-------------------------------------";
        return BookInfo;
    }

    public String displayBook(int bookChoice) {

        String BookInfo =
                "\n-------------------------------------" +
                "\nTitle:........................" + title +
                "\nAuthor:......................." + author +
                "\n-------------------------------------";
        return BookInfo;
    }

    public void createBook() {
        System.out.println("Is this book a Novel or an Art Album? ");
        kind = userInput.nextLine();

        if (kind.equalsIgnoreCase("novel")) {
            Book newBook = new Novel();
            newBook.createBook();
            BookList.add(newBook);//add the book to the BookList ArrayList.

            System.out.println("---------------------------------------------------------");
            System.out.println("> You have successfully added the book to the library!\n");
            System.out.println("---------------------------------------------------------");

        } else if (kind.equalsIgnoreCase("art album")) {
            Book newBook = new ArtAlbum();
            newBook.createBook();
            BookList.add(newBook);//add the book to the BookList ArrayList.

            System.out.println("---------------------------------------------------------");
            System.out.println("> You have successfully added the book to the library!\n");
            System.out.println("---------------------------------------------------------");

        } else {
            System.out.println("\n < MISSPELLING >  Check your input!!");
            choice = 5;
        }

    }

    public void displayBookList() {
        if (BookList.size() == 0) {//If the library is empty, it goes back to menu and choice.
            System.out.println(">-------------------------------------------------------------");
            System.out.println("\n> Library is Empty! Please add a book first!\n");
            System.out.println(">-------------------------------------------------------------");
            displayMenu();
            choice = choiceInput.nextInt();

        } else {
            for (int i = 0; i < BookList.size(); i++) {
                System.out.printf("\n> Book number: [%s]\n", i + 1);
                System.out.println(BookList.get(i).displayBook());
            }
        }
    }

    public void removeBook() {
        if (BookList.size() == 0) {
            System.out.println("---------------------------------------------------------");
            System.out.println("\n> Library is Empty! Please add a Book first!");
            System.out.println("---------------------------------------------------------");
            choice = 5;
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println("> Here are all the books registered in the library: ");
            System.out.println("---------------------------------------------------------");

            int i = 0;
            while (i < BookList.size() && BookList.size() > 0) {
                System.out.printf("\n> Book number: %s\n%s", i + 1, BookList.get(i).displayBook());
                i = i + 1;
            }

            System.out.println("\n\n> Choose an available book from the above list and write down it's number: ");
            bookChoice = choiceInput.nextInt(); //register user's book choice.

            if (bookChoice > 0 && bookChoice <= BookList.size()) {
                bookChoice--;
                System.out.printf("\n> The Book %s is deleted.\n", BookList.get(bookChoice).displayBook(bookChoice));
                BookList.remove(bookChoice);
                choice = 5;
            } else if (bookChoice == 0 || bookChoice > BookList.size()) {
                System.out.println("<ERROR> Please enter a number of book from the list: ");
                choice = 5;
            }
        }
    }

    public void emptyLibrary() {

        if (BookList.size() == 0) {
            System.out.println("---------------------------------------------------------");
            System.out.println("\n> Library is empty! Please add a Book first!");
            System.out.println("---------------------------------------------------------");
            choice = 5;
        } else {
            System.out.println("\n> WARNING < You have chosen to delete all books in the library! ");
            System.out.println("> Are you sure?? Enter yes or no: ");
            String confirmation = userInput.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                System.out.println("> Library is being deleted...");
                BookList.clear();
                System.out.println("> Library is Empty!");
                choice = 5;
            } else if (confirmation.equalsIgnoreCase("no")) {
                System.out.println("\n > Back to main menu.");
                choice = 5;
            } else {
                System.out.println("\n< MISSPELLING > Check your input.");
                choice = 4;
            }
        }
    }


    public void run() {

        displayMenu();//Displays the main menu and ask for choice.

        exit:

        while (choice == 0 || choice < 6) {

//Choice 1:
            if (choice == 1 && BookList.size() > 0) {

                displayBookList();
                choice = 5;
            }

            if (choice == 1 && BookList.size() == 0) {
                System.out.println("---------------------------------------------------------");
                System.out.println("\n> Library is Empty! Please add a Book first!");
                System.out.println("---------------------------------------------------------");
                choice = 5;
            }
//Choice 2:
            if (choice == 2) {
                //createBook();
                createBook();
                displayMenu();
            }
//Choice 3:
            if (choice == 3) {
                removeBook();
                if (BookList.size() > 0) {
                    displayMenu();
                } else {
                    choice = 5;
                }
            }
//Choice 4:
            if (choice == 4) {
                emptyLibrary();
            }
//Choice 5:
            if (choice == 5) {
                    displayMenu();
                }
//Choice 0:
            if (choice == 0) {
                break exit;
            }
//ERROR
            if (choice > 5 || choice < 0) {
                System.out.println("\n < ERROR >  Check your input!! The input must be a number from 0 to 4");
                choice = 5;
            }


        }//end of while loop.

        System.out.println("####  You have Exited the Library!  ####");

    }

}
