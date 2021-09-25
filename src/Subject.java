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
import java.util.ArrayList;
public class Subject {

    String subjectName = "";
    String subjectCode = "";

    Subject() {
    }

    Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    @Override
    public String toString() {
        return subjectCode + ": " + subjectName;
    }

    public boolean codeMatches(ArrayList<Subject> subjectList, String subjectCode) {
        for (Subject subject : subjectList) {
            if (subject.subjectCode.equals(subjectCode)) {
                System.out.println("\nSubject code already exists. It must be unique.");
                return false;
            }
        }
        return true;
    }

    /*  three tests to check the subject code, then length
        of the code, that the first three characters are
        letters and the last three characters are numbers
     */
    public static boolean isValidCode(String subjectCode) {
        /*  quick and easy to make sure the user only entered six characters
         */
        if (subjectCode.length() != 6) {
            System.out.println("\nSubject code must be six characters");
            return false;
        }
        /*  I'll split the subject code into the char part and the number part,
            so we can then check to see if it's a valid code before seeing if
            it's unique. I'll use regex to make sure the char part is only letters
            and the number part is only numbers
         */
        String charCode = subjectCode.substring(0, 3);
        if (!charCode.matches("[a-zA-Z]{3}")) {
            System.out.println("\nSubject code must start with three letters. For example ABC");
            return false;
        }
        String numCode = subjectCode.substring(3);
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
    public boolean codeExists(ArrayList<Subject> subjectList, String subjectCode) {
        return !codeMatches(subjectList, subjectCode);
    }

}
