abstract public class Student {
    int ID;
    double GPA;
    // Constructor
    public Student(int ID, double GPA) {
        this.ID = ID;
        this.GPA = GPA;
    }
    // GPA getter method
    public double getGPA() {
        return GPA;
    }

    // Abstract method to get the status as a string
    public abstract String getStatus();
    // display student details
    public String displayStudent() {
        String status = getStatus();
        return " ID>>" + ID + ", GPA>>" + GPA + ", Status>>" + status;
    }
}
