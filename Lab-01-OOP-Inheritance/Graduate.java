public class Graduate extends Student {

    // Constructor
    public Graduate(int ID, double GPA) {
        super(ID, GPA);
    }

    // Implementation of the abstract method for Graduate class
    @Override
    public String getStatus() {
        return (getGPA() >= 3.0) ? "Good" : "Probation";
    }
}
