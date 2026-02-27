import java.util.Scanner;

public class KMPImplementation {
    public static String searchKMP(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        StringBuilder indexes = new StringBuilder();

        // Preprocess the pattern (calculate lps[] array)
        // lps[] will hold the longest prefix suffix values for pattern
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                indexes.append((i - j)).append("  ");
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // mismatch after j matches
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        return indexes.toString();
    }

    static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int lps[] = new int[M];
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the pattern to search for: ");
        String pattern = scanner.nextLine();

        String indexes = searchKMP(pattern, text);
        if (indexes.isEmpty()) {
            System.out.println("Pattern not in text.");
        } else {
            System.out.println("Pattern found at these text starting indexes: " + indexes);
        }
    }
}
