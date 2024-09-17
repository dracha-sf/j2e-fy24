/*
Given a string, how many different substrings exist in it that have no repeating characters? Two substrings are considered
different if they have a different start or end index.
 */
package salesforce;

import java.util.HashSet;

/**
 *
 * @author hp
 */
public class stringProblem7 {
    static int distinctSubStrings(String str, int n)
    {
        // Hashmap to store all subStrings
        HashSet<String> S = new HashSet<String>();

        // iteratinf for all substrings
        for (int i = 0; i < n; ++i) {

            // Boolean array to check which characters have been encountered
            
            boolean []letters = new boolean[26];

            // Variable to maintain the subString till current position
           
            String s = "";

            for (int j = i; j < n; ++j) {

                // Get the position of the character in the String
               
                int pos = str.charAt(j) - 'a';

                // Check if the character is encountered
       
                if (letters[pos] == true)
                    break;

                letters[pos] = true;

                // Add the current character to the subString
                 
                s += str.charAt(j);

                // Insert subString in Hashmap
                S.add(s);
            }
        }

        return S.size();
    }

    public static void main(String[] args)
    {
        String s = "abac";
        int n = s.length();

        System.out.println(distinctSubStrings(s, n));
    }
}

