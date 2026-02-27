import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt user to enter the text string
            System.out.print("Enter a text string T: ");
            String text = scanner.nextLine();

            // Prompt user to enter the pattern string
            System.out.print("Enter a pattern string P: ");
            String pattern = scanner.nextLine();

            // Find all occurrences of the pattern in the text
            int occurrences = findAllOccurrences(text, pattern);

            // If pattern not found, print a message
            if (occurrences == 0) {
                System.out.println("Pattern not found.");
            }

            System.out.println(); // Print a new line for clarity
        }
    }

    // Method to find all occurrences of a pattern in a text using brute force algorithm
    public static int findAllOccurrences(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int occurrences = 0;

        // Loop through the text
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // Check if pattern matches starting at position i in the text
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break; // If mismatch, break out of the loop
                }
            }

            // If entire pattern matches, print the occurrence and its index
            if (j == patternLength) {
                // Print the text with aligned pattern and index
                System.out.println(text);
                for (int k = 0; k < i; k++) {
                    System.out.print(" "); // Align pattern with spaces
                }
                System.out.println(pattern); // Print the pattern
                System.out.println(i); // Print the index of the occurrence
                occurrences++; // Increment occurrence count
            }
        }

        return occurrences; // Return total occurrences found
    }
}
