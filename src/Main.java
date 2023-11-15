import parsers.BookParser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create name of file path that will be correct for a specific operating system
        String path = "src" + File.separator;
        try (Scanner scanner = new Scanner(System.in)) {

            //Interactive book title request from the user
            System.out.println("Enter the title of the book: ");
            String bookName = scanner.nextLine();

            // Check if the book is in the path directory
            File inputFile = new File(path, bookName);

            if (!inputFile.exists()) {
                System.out.println("Book with title " + bookName + " not found!");
                return;
            }

            //Get the full path to the file from which we are reading
            path = path + bookName;

            //Create object for parsing book and handle the exception
            BookParser bookParser = new BookParser();
            try {
                bookParser.parseBook(path);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }


        }
    }
}
