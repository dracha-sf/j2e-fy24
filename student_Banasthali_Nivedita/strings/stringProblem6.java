/*
The 26 characters of the alphabet are each assigned a security value represented as an array of integers, where
security_values[i] is associated with the i
th character of the alphabet. Given an encrypted message, msg, and the array
security_values, rearrange the characters in msg and find the minimum possible sum of the absolute differences of the
security values of adjacent characters.
 */
package salesforce;

import java.util.HashMap;
import java.util.Map;

public class stringProblem6 {
    public static int minDifference(int[] securityValues, String s) {
        // Create a mapping between characters and security values
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            mapping.put((char) ('a' + i), securityValues[i]);
        }

        // Convert the string to a character array
        char[] ch = s.toCharArray();

        // Sort the characters based on their security values using bubble sort
        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = 0; j < ch.length - i - 1; j++) {
                if (mapping.get(ch[j]) > mapping.get(ch[j + 1])) {
                    char temp = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = temp;
                }
            }
        }

        // Calculate the minimum sum of absolute differences
        int sum = 0;
        for (int i = 1; i < ch.length; i++) {
            int diff = Math.abs(mapping.get(ch[i]) - mapping.get(ch[i - 1]));
            sum += diff;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] securityValues = {1, 2, 1, 3, 1, 3, 5, 7, 1, 1, 5, 5, 8, 10, 11, 1, 23, 2, 3, 7, 8, 9, 1, 6, 5, 9};
        String s = "afeb";
        int result = minDifference(securityValues, s);
        System.out.println(result); // Output: 2
    }
}
