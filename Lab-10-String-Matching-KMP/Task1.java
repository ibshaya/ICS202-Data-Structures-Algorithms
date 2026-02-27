import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Keep asking for input from the user
        while (true) {
            System.out.print("Enter a text pattern: ");
            String pattern = scanner.nextLine();

            // Find the longest part that repeats at the beginning and end of the pattern
            String longestPrefixSuffix = findLongestPrefixSuffix(pattern);
            
            // If no repeating part found, tell the user
            if (longestPrefixSuffix.equals("")) {
                System.out.println("No repeating start and end part.");
            } 
            // Otherwise, show the repeating part and its length
            else {
                System.out.println("The repeating start and end part is: " + longestPrefixSuffix + ". It's " + longestPrefixSuffix.length() + " characters long.");
            }
        }
    }

    // Find the longest part that repeats at the beginning and end of a string
    public static String findLongestPrefixSuffix(String str) {
        int n = str.length();
        // Start from the middle and go towards the beginning
        for (int i = n / 2; i >= 0; i--) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(n - i);
            // Check if the prefix and suffix are the same
            if (prefix.equals(suffix)) {
                return prefix; // Return the repeating part
            }
        }
        return ""; // Return nothing if no repeating part found
    }
}
