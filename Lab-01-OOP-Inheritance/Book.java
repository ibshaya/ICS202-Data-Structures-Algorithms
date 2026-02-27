public class Book {
    private String title;
    private int pages;

    // Constructor
    Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }
    // Getter method for the title
    public String getTitle(){return title;}
    // Getter method for the number of pages
    public int getPages(){return pages;}
    // Setter method to update the number of pages
    public void setPages(int pages){
        this.pages = pages;
    }
    // Setter method to update the title
    public void setTitle(String title){
        this.title = title;
    }
    // toString method to display the book information
    public String toString(){
        return " Book: "+ title + ", # Pages = " + pages;
    }
}
