/*
An English lecture at Elementary School is aimed at teaching students the letters of the alphabet.
The students are provided with a string word that consists of lowercase English letters. In one move, they can choose any
index i, and let the character at that index be c. Then, the first occurrence of c to the left of i, and the first occurrence of c to
the right of i are deleted (Note: the operation can still be carried out even if either the left or right occurrence doesn't exist).
For example, if word = "adabacaea", and if index 4 is chosen (0-based), the first occurrence of 'a' to the left and right of index
4 (bold, indices 2 and 6) are deleted leaving word = "adbacea".
Find the minimum number of moves the students need to perform in order to get a word of minimal length.
 */
package salesforce;

public class stringProblem3 {
   public static int minimum_no_of_moves(String s) {
       
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        
        int i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            
            //left index of chosen leter's index
            int left = sb.lastIndexOf(String.valueOf(c), i - 1);
            
            //right index of chosen letter's index
            int right = sb.indexOf(String.valueOf(c), i + 1);
            
            
            if (left != -1 && right != -1) {
                
                //remove characters present at left and right indices
                sb.deleteCharAt(right);
                sb.deleteCharAt(left);
                
                //increment count for each iteration
                count++;
                
                i = Math.max(left - 1, 0);
            } 
            
            //if left and right indices are -1
            else {
                i++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String word = "baabacaa";
        int result = minimum_no_of_moves(word);
        System.out.println(result);
    }
}

