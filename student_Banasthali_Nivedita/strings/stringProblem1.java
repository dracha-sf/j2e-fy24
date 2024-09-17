/*
Two strings are said to be the same if they are of the same length and have the same character at each index. Backspacing in
a string removes the previous character in the string.
Given two strings containing lowercase English letters and the character '#' which represents a backspace key, determine if the
two final strings are equal. Return 1 if they are equal or 0 if they are not.
Note that backspacing an empty string results in an empty string.

 */
package salesforce;

public class stringProblem1 {
   
    private static String checkStr(String s) {
        StringBuilder sb = new StringBuilder();
        
        //traverse the string
        for (char c : s.toCharArray()) {
            if (c == '#') {
                //remove the previous character if backspace is encountered
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                //append the character to string
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static boolean compareBs(String s1, String s2) {
        
        //ckeck strings
        String S1 = checkStr(s1);
        String S2 = checkStr(s2);
        
        //return true if equal else false
        return S1.equals(S2);
    }
    
    public static void main(String[] args) {
        
        //output --> 0
        String s1 = "axxb#bb#c";
        String s2 = "axbcd#c#c";
        
        //output --> 1
        //String s1 = "axx#bb#c";
        //String s2 = "axbd#c#c";
        boolean result = compareBs(s1, s2);
        
        if(result==true){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
        
    }
}
