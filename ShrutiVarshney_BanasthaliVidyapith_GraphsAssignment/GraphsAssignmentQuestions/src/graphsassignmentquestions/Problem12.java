package graphsassignmentquestions;
import java.util.*;
public class Problem12
{
    public int jump(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n]; // dp[i] represents the minimum number of steps to reach index i

        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize all elements with a large value except dp[0]
        dp[0] = 0;

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (j + nums[j] >= i) 
                {
                    // If we can reach index i from index j, update dp[i] with the minimum steps
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 1, 1, 4};

        Problem12 solution = new Problem12();
        int minSteps = solution.jump(nums);
        System.out.println(minSteps); // Output: 2
    }
}
