package ro.homework;

public class Novel extends Book {

    protected String type;

    public String displayBook() {

        String BookInfo =
                "\n-------------------------------------" +
                "\nTitle:........................" + title +
                "\nAuthor:......................." + author +
                "\nNumber of Pages:.............." + page +
                "\nType:........................." + type +
                "\nKind:........................." + kind +
                "\n-------------------------------------";
        return BookInfo;
    }

    public void createBook() {
        System.out.println("Enter the title of the novel: ");
        title = userInput.nextLine();

        System.out.println("Enter the author of the novel: ");
        author = userInput.nextLine();

        System.out.println("Enter the number of pages: ");
        page = userInput.nextLine();

        System.out.println("Enter the type of the novel: ");
        type = userInput.nextLine();

        kind = "Novel";

        }
}
