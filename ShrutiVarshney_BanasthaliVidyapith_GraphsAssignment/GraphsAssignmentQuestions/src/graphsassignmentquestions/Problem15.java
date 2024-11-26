package graphsassignmentquestions;
import java.util.*;
public class Problem15
{
    public int numDecodings(String s) 
    {
        int n = s.length();
        
        // Create a dp array to store the number of ways to decode the substring ending at index i
        int[] dp = new int[n + 1];
        
        // Initialize the base cases
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        // Fill in the dp array
        for (int i = 2; i <= n; i++) {
            // Check if the current digit can be decoded on its own
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9)
            {
                dp[i] += dp[i - 1];
            }
            
            // Check if the current digit can be decoded with the previous digit
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args)
    {
        String s = "226";
        
        Problem15 solution = new Problem15();
        int numDecodings = solution.numDecodings(s);
        System.out.println(numDecodings); // Output: 3
    }
}
