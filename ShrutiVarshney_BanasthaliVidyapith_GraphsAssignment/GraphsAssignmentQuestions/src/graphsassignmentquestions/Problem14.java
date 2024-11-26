package graphsassignmentquestions;
import java.util.*;
public class Problem14 
{
    public int minSwaps(int[] nums) 
    {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Create an array of pairs (number, index)
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort the array of pairs based on the numbers
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++)
        {
            // If the element is already visited or in the correct position, skip it
            if (visited[i] || pairs[i][1] == i)
                continue;

            int cycleSize = 0;
            int j = i;

            // Find the size of the cycle
            while (!visited[j]) 
            {
                visited[j] = true;
                j = pairs[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 3, 1, 2};

        Problem14 solution = new Problem14();
        int minSwaps = solution.minSwaps(nums);
        System.out.println(minSwaps); 
    }
}
