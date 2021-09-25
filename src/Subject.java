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

    public boolean codeMatches(String subjectCode) {
        return true;
    }

    public boolean isValidCode(String subjectCode) {
        return true;
    }

    public boolean codeExists(String[] subjects, String subjectCode) {
        return true;
    }

}
