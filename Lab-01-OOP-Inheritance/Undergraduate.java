public class Undergraduate extends Student {

    // Constructor
    public Undergraduate(int ID, double GPA) {
        super(ID, GPA);
    }
    // Implementation of the abstract method for Undergraduate class
    @Override
    public String getStatus() {
        if (getGPA() >= 3.0) {
            return "Honor";
        } else if (getGPA() >= 2.0) {
            return "Good";
        } else {
            return "Probation";
        }
    }
}