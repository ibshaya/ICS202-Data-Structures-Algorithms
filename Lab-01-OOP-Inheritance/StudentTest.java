
import java.util.Random;

public class StudentTest {

    public static void main(String[] args) {
        // Generating the details for 10 students
        for (int i = 1; i <= 10; i++) {
            int studentType = new Random().nextInt(2);
            int studentID = 1000 + i;
            double studentGPA = Math.round((1 + Math.random() * 3) * 10) / 10.0; 

            Student student;
            if (studentType == 0) {
                student = new Undergraduate(studentID, studentGPA);
            } else {
                student = new Graduate(studentID, studentGPA);
            }
            //Printing the student details

            System.out.println((student instanceof Undergraduate ? "Undergraduate" : "Graduated")+student.displayStudent());
        }
    }
}