public class NextArray {
    public static int[] computeNextArray(String x) {
        int[] next = new int[x.length() + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < x.length()) {
            while (j == -1 || i < x.length() && (x.charAt(i) == x.charAt(j))) {
                i++;
                j++;
                next[i] = j;
            }

            j = next[j];
        }

        return next;
    }

    public static void printTable(String pattern) {
        int[] next = computeNextArray(pattern);
        System.out.println("Pattern: " + pattern);
        System.out.println("j\tPattern [0..j-1]\tProper prefixes\tProper Suffixes\tnext[j]");
        for (int j = 0; j <= pattern.length(); j++) {
            System.out.print(j + "\t");
            if (j == 0) {
                System.out.println("-\tnull\tnull\t" + next[j]);
            } else {
                String patternSubstring = pattern.substring(0, j);
                String properPrefixes = patternSubstring.substring(0, next[j]);
                String properSuffixes = patternSubstring.substring(j - next[j], j);
                System.out.println(patternSubstring + "\t" + properPrefixes + "\t" + properSuffixes + "\t" + next[j]);
            }
        }
        System.out.println("\nThe next array is:");
        for (int i = 0; i <= pattern.length(); i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // Verify pattern (a) ABCDE
        printTable("ABCDE");

        // Verify pattern (b) AAAAA
        printTable("AAAAA");

        // Verify pattern (c) ABABAMK
        printTable("ABABAMK");
    }
}
