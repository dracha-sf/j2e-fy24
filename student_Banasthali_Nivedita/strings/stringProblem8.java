/*
A palindrome is a string that reads the same from the left and from the right. For example, mom and tacocat are palindromes,
as are any single-character strings. Given a string, determine the number of its substrings that are palindromes.
 */
package salesforce;

public class stringProblem8 {
    public static int count_palindrome_substrings(String s) {
        int count = 0;
        int n = s.length();

        // Count single-character substrings
        count += n;

        // Check for palindromic substrings of length 2 or more
        for (int i = 0; i < n; i++) {
            
            // Palindromic substrings of length 2
            count += expandPalindrome(s, i, i + 1);

            // Palindromic substrings of length 3 or more
            count += expandPalindrome(s, i - 1, i + 1);
        }

        return count;
    }

    public static int expandPalindrome(String s, int left, int right) {
        int count = 0;
        int n = s.length();

        // Expand the palindrome around the center characters
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "tacocat";
        int result = count_palindrome_substrings(s);
        System.out.println(result); // Output: 10
    }

}

