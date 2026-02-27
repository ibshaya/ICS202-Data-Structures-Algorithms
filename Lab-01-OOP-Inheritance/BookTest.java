
public class BookTest {
    public static void main(String[] args) {
        // Create an array of Book objects
        Book[] books = new Book[10];
        // Initialize the array with different types of books
        books[0] = new Book("ABC", 100);
        books[1] = new Book("Arabic", 100);
        books[2] = new Textbook("Data structure, ICS-102", 200, "ICS-102");
        books[3] = new Textbook("Algebra, MATH-101", 500, "MATH-101");
        books[4] = new Book("Water Conservation", 200);
        books[5] = new Book("Environment" , 150);
        books[6] = new Book("Teach yourself Visual C++", 300);
        books[7] = new Book("Notebbok", 300);
        books[8] = new Book("life", 200);
        books[9] = new Textbook("apply phys, phys-102", 600, "phys-102");

        // Counters for the number of regular books and textbooks

        int booksNumber=0 ;
        int textNumber=0 ;
        for(int i = 0 ; i< books.length ; i++){
            // Print information about each book
            System.out.println(books[i]);
            // Check if the current book is an instance of Textbook
            if(books[i] instanceof Textbook){
                textNumber++;
            }
            else{
                booksNumber++;
            }
        }
        // Print the total number of books and textbooks
        System.out.println("Number of Books = " +booksNumber + "\n Number of TextBooks = " + textNumber);
    }
}