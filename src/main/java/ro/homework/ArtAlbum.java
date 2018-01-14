package ro.homework;

public class ArtAlbum extends Book{

    protected String paperQ;

    public String displayBook() {

        String BookInfo = "----------------------------" +
                "\nTitle:........................" + title +
                "\nAuthor:......................." + author +
                "\nNumber of Pages:.............." + page +
                "\nPaper Quality:................" + paperQ +
                "\nKind:........................." + kind +
                "\n-------------------------------------";
        return BookInfo;
    }

    public void createArt() {
        System.out.println("Enter the title of the art album: ");
        title = userInput.nextLine();

        System.out.println("Enter the author of the art album: ");
        author = userInput.nextLine();

        System.out.println("Enter the number of pages: ");
        page = userInput.nextLine();

        System.out.println("Enter the quality of the art album's paper: ");
        paperQ = userInput.nextLine();

        status = "Available";
    }
}

