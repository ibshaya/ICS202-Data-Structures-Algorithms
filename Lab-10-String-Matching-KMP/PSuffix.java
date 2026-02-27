public class PSuffix {
    static void countSamePrefixSuffix(String s) {
        int n = s.length();

        // Iterate through all substrings of s
        for (int len = 1; len <= n; len++) {
            System.out.println("Substring: ");
            System.out.println("-------------------------------");
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                System.out.println("Substring: " + substr);
                if (substr.length() > 1) {
                    // Generate proper prefixes and suffixes for the substring
                    countProperPrefixSuffix(substr);
                }
                System.out.println("-------------------------------");
            }
        }
    }

    // Method to count proper prefix and suffix for a given string
    static void countProperPrefixSuffix(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(n - i, n);

            // Check if prefix and suffix are equal and print them
            if (prefix.equals(suffix)) {
                System.out.println("Proper prefix: " + prefix + ", Proper suffix: " + suffix + " *" + prefix.length());
            } else {
                System.out.println("Proper prefix: " + prefix + ", Proper suffix: " + suffix);
            }
        }
    }

    public static void main(String[] args) {
        String pattern = "ABCAABC";
        countSamePrefixSuffix(pattern);
    }
}
