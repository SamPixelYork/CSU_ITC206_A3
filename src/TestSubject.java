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
import java.util.Scanner;

public class TestSubject {
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
            Task1.mainMenu();
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

    /*  three tests to check the subject code, then length
        of the code, that the first three characters are
        letters and the last three characters are numbers
     */
    public static boolean isValidCode(String inCode) {
        /*  quick and easy to make sure the user only entered six characters
         */
        if (inCode.length() != 6) {
            System.out.println("\nSubject code must be six characters");
            return false;
        }
        /*  I'll split the subject code into the char part and the number part,
            so we can then check to see if it's a valid code before seeing if
            its unique. I'll use regex to make sure the char part is only letters
            and the number part is only numbers
         */
        String charCode = inCode.substring(0, 3);
        if (!charCode.matches("[a-zA-Z]{3}")) {
            System.out.println("\nSubject code must start with three letters. For example ABC");
            return false;
        }
        String numCode = inCode.substring(3);
        if (!numCode.matches("[0-9]{3}")) {
            System.out.println("\nSubject code must end with three numbers. For example 123");
            return false;
        }
        return true;
    }

    /*  to see if the subject code is unique, a simple
        loop through the arraylist for the subject code
        items for a match
     */
    public static boolean codeExists(String inCode) {
        for (Subject subject : subjectList) {
            if (subject.subjectCode.equals(inCode)) {
                System.out.println("\nSubject code already exists. It must be unique.");
                return false;
            }
        }
        return true;
    }

    /*  a standard add new subject to the arraylist method
     */
    public static void addSubject(String inCode, String inName) {
        subjectList.add(new Subject(inCode, inName));
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
