public class Textbook extends Book{
    private String course ;

    // Constructor
    Textbook(String title, int pages, String course){
        super(title, pages);
        this.course =course;
    }

    // Getter method for the course
    public String getCourse() {
        return course;
    }
    // Setter method to update the course
    public void setCourse(String course){
        this.course =course;
    }

    // toString method to display the Textbook information
    @Override
    public String toString(){
        return "Text"+ super.toString() + ", Course= "+course ;

    }

}
