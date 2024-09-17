/*
A string is a pangram if it contains all letters of the English alphabet, ascii['a'-'z']. Given a list of strings, determine if each one is
a pangram or not. Return "1" if true and "0" if false.
 */
package salesforce;

public class stringProblem4 {
    
    public static String chkPngrm(String[] pangram) {
        
        StringBuilder result = new StringBuilder();
        
        for (String s : pangram) {
            
            //create a letters array to keep track of the letters in the string
            boolean[] letters = new boolean[26];
            int count = 0;
            
            // Converting the string to lowercase to avoid case sensetivity issues
            s = s.toLowerCase();
            
            for (char c : s.toCharArray()) {
                
                //if character belongs to the lowercase alphabet and it not encountered 
                //before in the iteration then 
                if (c >= 'a' && c <= 'z' && !letters[c - 'a']) {
                    
                    //converting the character to its corresponding index in the alphabet
                    letters[c - 'a'] = true;
                    
                    //increment the count if all conditions are satisfied
                    count++;
                }
                
                // break the loop if all letters are found
                if (count == 26) {
                    break;
                }
            }
            
            // Append "1" if the string is a pangram, "0" otherwise
            if (count == 26) {
                result.append("1");
            } else {
                result.append("0");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String[] pangram = {
            "pack my box with five dozen liquor jugs",
            "this is not a pangram","Sphinx of black quartz, judge my vow"
        };
        
        String result = chkPngrm(pangram);
        System.out.println(result);
    }
}
