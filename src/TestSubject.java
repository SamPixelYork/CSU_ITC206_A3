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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestSubject {

    public static void main(String[] args) {
        loadFile();
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


    private static final ArrayList<Subject> subjectList = new ArrayList<>();
    /*  I'll use an arraylist to store the subjects as we don't
    know how many there'll be. For initial data I've created
    a startdata.txt text file with some subjects. Each line has
    six characters for the subject code, then separated by a comma,
    the subject name.
 */
    public static void loadFile() {
        try {
            File file = new File("startdata.txt");
            Scanner inFile = new Scanner(file);
            while (inFile.hasNextLine()) {
                String[] temp = inFile.nextLine().split(",");
                subjectList.add(new Subject(temp[0], temp[1]));
            }
            inFile.close();
        } catch (Exception e) {
            System.out.println("File startdata.txt does not exist");
            System.out.println("Initial subjects will not be populated");
            mainMenu();
        }
    }

    /*  simple method for outputting the arraylist into a text file,
        a line for each subject and the code and name separated by
        a comma
     */
    public static void writeFile() {
        try {
            File file = new File("subjects.txt");
            PrintWriter outFile = new PrintWriter(file);
            for (Subject subject : subjectList) {
                outFile.print(subject.getSubjectCode() + "," + subject.getSubjectName() + "\n");
            }
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        if (!Subject.isValidCode(subjectCode))
            addSubject(); // if false ask user to input the subject code again
        /*  Executive decision to allow any case letters as the subject code,
            and I'll just upper case the input
         */
        subjectCode = subjectCode.toUpperCase();
        if (!TestSubject.codeExists(subjectCode))
            addSubject(); // if false ask user to input the subject code again
        System.out.print("Please enter in the new subject name: ");
        subjectName = input.next();
        subjectList.add(new Subject(subjectCode, subjectName));
        mainMenu();
        input.close();
    }



    public static boolean codeExists(String inCode) {
        for (Subject subject : subjectList) {
            if (subject.subjectCode.equals(inCode)) {
                System.out.println("\nSubject code already exists. It must be unique.");
                return false;
            }
        }
        return true;
    }

    /*  print each current subject in the arraylist
     */
    public static void printSubjects() {
        System.out.println("\nList of existing subjects\n-------------------------");
        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
    }

}
