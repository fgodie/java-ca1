/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;
import javax.swing.JOptionPane;
/**
 *
 * @author wongj
 * Class: DIT/FT/2B/23
 * Admission Number: P2329354
 * Name: Wong Jun Hong
 */


public class StudentUser extends Student {


    // menu option list
    private static final String[] menuOption = { "Enter your option: \n\n",
            "1. Display all students",
            "2. Search student by class\n",
            "3. Search student by name\n",
            "4. Quit\n" };

    // view model
    public static String viewGetuserInput() {

        return JOptionPane.showInputDialog(null,
                menuOption,
                "Student Enquiry System",
                JOptionPane.QUESTION_MESSAGE);

    }

    // done
   public static String viewstudentInfo(Student[] studentArr) {
        String resultMessage = ""; // Initialize resultMessage outside the loop

        for (int count = 0; count < studentArr.length; count++) {
            Student student = studentArr[count];
            resultMessage += "Student " + (count + 1) + ":" +
                    "\nName:" + student.getStudentName() +
                    "\nAdmin:" + student.getAdminNo() +
                    "\nClass:" + student.getStudentClass() +
                    "\nModule Taken:" + student.getModule() + "\n-----------------\n";
        }

        JOptionPane.showMessageDialog(null, resultMessage, "All Student report", JOptionPane.INFORMATION_MESSAGE);

        return resultMessage;
    }
    // done
    private static String viewSearchByClassInput() {
        String userinput;
        userinput = JOptionPane.showInputDialog(null,
                "Enter the class name to search",
                "Search",
                JOptionPane.QUESTION_MESSAGE);

        return userinput;

    };

    // done
    private static void viewUserInputInvalid() {

        JOptionPane.showMessageDialog(null,
                "Invalid choice, Please select again!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // done
    private static String viewSearchByNameInput() {

        return JOptionPane.showInputDialog(null,
                "Enter the student name to search:",
                "Input",
                JOptionPane.QUESTION_MESSAGE);

    }

    // done
    private static void viewUserQuitMessage() {

        JOptionPane.showMessageDialog(null,
                "Program terminated.\nThank You!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE);

    }

    // done
    private static void viewUserInputNameisBlank() {

        JOptionPane.showMessageDialog(null, "No name entered, Please enter again", "Info",
                JOptionPane.ERROR_MESSAGE);

    }

    private static void viewUserInputClassisBlank() {

        JOptionPane.showMessageDialog(null, "No class entered, Please enter again", "Info",
                JOptionPane.ERROR_MESSAGE);

    }

    // controller
    // done
    private static boolean controllerIfStudentNameisBlank(String input) {

        return input.isBlank();

    }

    private static boolean controllerIfStudentClassisBlank(String input) {

        return input.isBlank();

    }


    // done
    private static String ModelSeacrhByClassResult(String input, Student[] studentArr) {

        int count = 0;
        String resultMessage = "";
        double GPA = 0.0;

        for (int i = 0; i < studentArr.length; i++) {
            if (input.equals(studentArr[i].getStudentClass())) {
                GPA += studentArr[i].getGPA();
                count++;
            }
        }

        if (count > 0) {
            resultMessage = "Number of student(s) in " + input + ": " + count + "\nAverage GPA:" + GPA;
        } else {
            resultMessage = "No students found from class! ";
        }

        JOptionPane.showMessageDialog(null, resultMessage, "Class Summary", JOptionPane.INFORMATION_MESSAGE);

        return resultMessage;
    };

    // done
    private static String ModelSeacrhByNameResult(String input, Student[] studentArr) {

        String resultMessage = "";
        boolean studentFound = false;


        for (int i = 0; i < studentArr.length; i++) {
            if (input.equals(studentArr[i].getStudentName().toLowerCase())) {
                Student student = studentArr[i];
                resultMessage += 
                        "Name:" + student.getStudentName() +
                        "\nAdmin:" + student.getAdminNo() +
                        "\nClass:" + student.getStudentClass() +
                        "\nModule Taken:" + student.getModule() +
                        "\n\nGPA:" + student.getGPA() +
                        "\n-----------------\n";

                studentFound = true;
                break;
            }
        }

            if (studentFound) {
                JOptionPane.showMessageDialog(null, resultMessage, "Student Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String errorMessage = String.format("Cannot find the student \"%s\"!!", input);
                JOptionPane.showMessageDialog(null, errorMessage, "Info", JOptionPane.ERROR_MESSAGE);
            }
        
            return resultMessage;

    }


    public static void main(String[] args) {

        // booting up
        // =====================
        String strUserInput = "";

        // dummy student info array
        Student[] studentArr = new Student[3];

        // //booting up
        studentArr[0] = new Student("John Tan", "p2312333", "DIT/FT/2A/01", "\n1. ST0509/JPRG/4: A \n2. ST0503/FOP/5: B",
                3.59);

        studentArr[1] = new Student("Samsudin", "p2312555", "DIT/FT/2A/02", "\n1. ST0509/JPRG/4: B \n2. ST0503/FOP/5: A",
                3.56);

        studentArr[2] = new Student("Wong Jun Hong", "p2329354", "DIT/FT/2B/23",
                "\n1. ST0509/JPRG/4: A \n2. ST0503/FOP/5: B", 3.55);

        // main program do-while loop

        do {
            // Get user input
            strUserInput = viewGetuserInput();

            // Process user input
            switch (strUserInput) {
                case "1":
                    viewstudentInfo(studentArr);
                    break;
                case "2":
                    strUserInput = viewSearchByClassInput();
                    if (controllerIfStudentClassisBlank(strUserInput)) {
                        viewUserInputClassisBlank();
                    }else{
                        ModelSeacrhByClassResult(strUserInput, studentArr);
                    }
                    break;
                case "3":
                    strUserInput = viewSearchByNameInput();
                    if (controllerIfStudentNameisBlank(strUserInput)) {
                        viewUserInputNameisBlank();
                    }else{
                        ModelSeacrhByNameResult(strUserInput, studentArr);
                    }
                    break;
                case "4":
                    viewUserQuitMessage();
                    break;
                default:
                    viewUserInputInvalid();
                    break;
            }

        } while (!strUserInput.equals("4")); // Repeat until user chooses to quit (option 4)

    }
}
