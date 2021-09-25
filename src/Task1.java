
/**
 *   Sam Pixel York
 *   #11719416
 *   25 SEP 2021
 *
 *   ITC206: Programming in Java 2
 *   Assessment 1: Programming Tasks
 *
 *   Task 1: Subject list
 *   Add new subjects to a list of current subjects
 *   as long as the subject code is unique. Output
 *   the final list to a text file
 */
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        TestSubject.loadFile();
        mainMenu();
    }


    /*  Quick and easy console menu for entering in new subjects, viewing
        current subjects, or outputting current subjects to a text file.
        If the user input doesn't match any of the options, the menu will
        just show again
     */
    public static void mainMenu() {
        try {
            System.out.print("\nMain menu\n---------\n");
            System.out.println("1. Add new subjects");
            System.out.println("2. View current subjects");
            System.out.println("3. Save subjects to subjects.txt");
            System.out.println("4. Exit program\n");
            System.out.print("Selection: ");
            Scanner input = new Scanner(System.in);
            int menuSelection = input.nextInt();
            switch (menuSelection) {
                case 1 -> addSubject();
                case 2 -> {
                    TestSubject.printSubjects();
                    mainMenu();
                }
                case 3 -> {
                    TestSubject.writeFile();
                    mainMenu();
                }
                case 4 -> System.exit(1);
                default -> {
                    System.out.println("Option unavailable, please try again");
                    mainMenu();
                }
            }
            input.close();
        } catch (InputMismatchException e) {
            System.out.println("Input must be a number, please try again");
            mainMenu();
        }
    }

    /*  before adding the new subject, we'll run the subject code
        through the tests in the TestSubject class. The subject name
        doesn't go through any tests.
     */
    public static void addSubject() {
        Scanner input = new Scanner(System.in);
        TestSubject.printSubjects();
        String subjectCode, subjectName;
        System.out.print("\nPlease enter in the new six character subject code: ");
        subjectCode = input.next();
        if (!TestSubject.isValidCode(subjectCode))
            addSubject();
        /*  Executive decision to allow any case letters as the subject code,
            and I'll just upper case the input
         */
        subjectCode = subjectCode.toUpperCase();
        if (!TestSubject.codeExists(subjectCode))
            addSubject();
        System.out.print("Please enter in the new subject name: ");
        subjectName = input.next();
        TestSubject.addSubject(subjectCode, subjectName);
        mainMenu();
        input.close();
    }
}
