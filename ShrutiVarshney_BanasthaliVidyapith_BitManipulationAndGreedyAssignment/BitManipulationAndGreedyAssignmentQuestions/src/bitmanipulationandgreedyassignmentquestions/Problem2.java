package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem2 
{
    public static int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize the dp array with a value greater than the amount
        
        dp[0] = 0; // Base case: 0 coins needed to make amount 0
        
        for (int i = 1; i <= amount; i++) 
        {
            for (int j = 0; j < coins.length; j++) 
            {
                if (coins[j] <= i) 
                {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static void main(String[] args) 
    {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int minCoins1 = coinChange(coins1, amount1);
        System.out.println("Example 1: " + minCoins1);
        
        int[] coins2 = {2};
        int amount2 = 3;
        int minCoins2 = coinChange(coins2, amount2);
        System.out.println("Example 2: " + minCoins2);
    }
}
