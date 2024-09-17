/*
Data, in the form of a binary string has to be sent across two servers. However, according to a new network control protocol,
data can only be sent in the form of binary strings that have no two adjacent characters same. Such binary strings with no two
adjacent characters same are called special strings. Any data to be transmitted is first broken into one/numerous
subsequences that are special strings and then each special string is sent as a data packet across the connected servers.
Given a binary string that has to be sent across two servers, find the minimum number of data packets it will be broken into.
Note: A subsequence of a string is obtained by deleting some characters from the string while maintaining the order. For
example, "011" is a subsequence of "0101" while "100" is not.
*/
package salesforce;

public class stringProblem2 {
    public static int spString(String s) {
        int l = s.length();
        int count=0;
        
        int i=0;
        
        //traverse the string
        while (i<l) {
            
            //count the first character as sepcial
            count++;
            
            //if alternate characters are same
            if (i+1 < l && s.charAt(i) == s.charAt(i + 1)) {
                i += 2; // Skip the adjacent characters
            } else {
                i++; // Move to the next character
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        String s = "110011001";
        int result = spString(s);
        System.out.println(result);
    }
}
