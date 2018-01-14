package ro.homework;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {

    public String title;
    public String author;
    public String page;
    public String status;

    public int BookChoice;

    static ArrayList<Book> BookList = new ArrayList<Book>();

    static int choice ;

    static Scanner userInput = new Scanner(System.in);
    static Scanner choiceInput = new Scanner(System.in);

    public static void displayMenu(){

        System.out.println("1- Check library list.");
        System.out.println("2- Add a book to the Library.");
        System.out.println("5- Delete a book.");
        System.out.println("6- Blow up library.");
        System.out.println("7- Back to main menu.");
        System.out.println("0- Exit.");
        System.out.println("> Enter your option here: ");
        choice = choiceInput.nextInt();//User inputs a choice (integer).

    }

    public String displayBook(){

        String BookInfo = "----------------------------"+
                "\nTitle:........................"+title+
                "\nAuthor:......................."+author+
                "\nNumber of Pages:.............."+page+
                "\n----------------------------";
        return BookInfo;
    }

    public void createBook(){
        System.out.println("> Enter the title of the book: ");
        title = userInput.nextLine();

        System.out.println("> Enter the author of the book: ");
        author = userInput.nextLine();

        System.out.println("> Enter the number of pages: ");
        page = userInput.nextLine();

        status = "Available";
    }

    public void addBook(){
        Book newBook = new Book(); //create new book object with status "Available."
        newBook.createBook();
        BookList.add(newBook);//add the book to the BookList ArrayList.
        System.out.println("---------------------------------------------------------");
        System.out.println("> You have successfully added the book to the library!\n");
        System.out.println("---------------------------------------------------------");
    }

    public void displayBookList(){
        if (BookList.size() == 0){//If the library is empty, it goes back to main menu and choice.
            System.out.println(">-------------------------------------------------------------");
            System.out.println("> There Library is Empty! Please add a book first!\n");
            System.out.println(">-------------------------------------------------------------");
            Book.displayMenu();//Display to main menu.
            choice = choiceInput.nextInt();//Register new choice.

        } else {
            for (int i = 0; i < BookList.size(); i++){
                System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n",i+1);
                System.out.println(BookList.get(i).displayBook());
                System.out.println(">-------------------------------------------------------------");
            }//End of For Loop.
        }// End of Else Statement.
    }//End of if Statement.

    public void removeBook(){
        int i = 0;
        System.out.println("---------------------------------------------------------");
        System.out.println("> Here are all the books registered in the library: ");
        System.out.println("---------------------------------------------------------");

        while (i < BookList.size() && BookList.size() > 0){//show the user the list of all the books
            System.out.printf("\n> Book number %s:\n%s",i+1,BookList.get(i));
            i = i+1;
        }//end of while loop.

        System.out.println("\n\n> Choose an available book from the above list and write down it's number: ");
        int BookChoice = choiceInput.nextInt()-1;//register user's book choice.

        while(choice == 5){
            try{
                if (BookChoice > 0 && BookChoice < BookList.size() && BookList.get(BookChoice).status.equalsIgnoreCase("Available")){//Check if the book to be borrowed is available.
                    //Print the borrowed book information and change the book status to borrowed.
                    BookList.remove(BookChoice);
                    System.out.printf("\n> You have chosen to delete the following book: %s\n", BookList.get(BookChoice));
                    System.out.printf("\n> The Book %s is deleted.\n", BookList.get(BookChoice));
                    choice = 7;
                }
            }catch(InputMismatchException error){
                System.out.println("<ERROR> Please enter a number of book from the list: ");
                choiceInput.nextInt();
                choice = 5;
            }catch(IndexOutOfBoundsException error){
                System.out.println("<ERROR> Please enter a number of book from the list: ");
                choice = 5;
            }
        }
    }


    public void emptyLibrary(){
        System.out.println("> WARNING < You have chosen to delete all books in the library! ");
        System.out.println("> Are you sure?? Enter yes or no: ");
        String confirmation = userInput.nextLine();
        try{
            if(confirmation.equalsIgnoreCase("yes")){
                System.out.println("> Library is being deleted...");
                BookList.clear();
                System.out.println("> Library is Empty!");
                choice = 7;
            }
        }catch(InputMismatchException error){
            System.out.println("<ERROR> Make sure you spell yes or no correctrly: ");
            choice = 6;
        }
    }

    public void run(){

        Book.displayMenu();//Displays the main menu and ask for choice.

        exit:

        while(choice != 0){
            try{
//Choice 1:
                if(choice == 1 && BookList.size() > 0){

                    displayBookList();
                    choice = 7;
                }

                if(choice == 1 && BookList.size() == 0){
                    System.out.println("<ERROR> Library is empty! Please add a Book first!");
                    choice = 7;
                }
//Choice 2:
                if(choice == 2){
                    //createBook();
                    addBook();
                    displayMenu();
                }
//Choice 5:
                if(choice == 5){
                    removeBook();
                    try{
                        if(BookList.size() > 0){
                            displayMenu();
                        }
                    }catch(IndexOutOfBoundsException error){
                        System.out.println("<ERROR> The array is Empty! Please add a book first!");
                        choice = 7;
                        //break; //Test the Break statement!!!!!!!!!!!!!!!!!!!
                    }
                }
//Choice 6:
                if(choice == 6){
                    emptyLibrary();
                }
//Choice 7:
                if(choice == 7){
                    if(BookList.size() > 0){
                        displayMenu();
                    }else if(BookList.size() == 0){
                        displayMenu();
                    }
                }
//Choice 0:
                if(choice == 0){
                    break exit;
                }
            }catch(InputMismatchException error){
                System.out.println("@TEST@ <<< 5- Breaking from main while loop... >>>>");
                break exit;
            }

        }//end of while loop.

        System.out.println("####  You have Exited the Library!  ####");

    }//End of run() method.


    /**
     * ===================================================================================================
     * End of Class Methods.
     * ===================================================================================================
     */

    public static void main(String[] args){

        System.out.println("> Welcome to the library!");

        Book newBook = new Book();
        newBook.run();

    }//End of Main Method.

}
