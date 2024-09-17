/*
Different compression techniques are used in order to reduce the size of the messages sent over the web. An algorithm is
designed to compress a given string by describing the total number of consecutive occurrences of each character next to it.
 */
package salesforce;

/**
 *
 * @author hp
 */
public class stringProblem9 {
    public static String compress(String msg) {
        
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        for (int i = 0; i < msg.length() - 1; i++) {
            
            //if current char is same as next char, increment count and append value of count else append the next char
            if (msg.charAt(i) == msg.charAt(i + 1)) {
                count++;
            } else {
                sb.append(msg.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        
        // Append the last character and its count if applicable
        sb.append(msg.charAt(msg.length() - 1));
        if (count > 1) {
            sb.append(count);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String msg = "abaasass";
        String compressedString = compress(msg);
        System.out.println("Compressed string: " + compressedString);
    }
}


