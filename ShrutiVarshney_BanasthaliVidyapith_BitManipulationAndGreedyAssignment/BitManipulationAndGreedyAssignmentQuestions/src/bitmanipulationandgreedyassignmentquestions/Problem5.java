package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem5 
{
    public static List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> subsets) 
    {
        subsets.add(new ArrayList<>(currentSubset)); // Add the current subset to the result

        for (int i = start; i < nums.length; i++) 
        {
            currentSubset.add(nums[i]); // Include the current element in the subset
            backtrack(nums, i + 1, currentSubset, subsets); // Recursively generate subsets using the remaining elements
            currentSubset.remove(currentSubset.size() - 1); // Backtrack: remove the current element from the subset
        }
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> subsets1 = subsets(nums1);
        System.out.println(subsets1); // Output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

        int[] nums2 = {0};
        List<List<Integer>> subsets2 = subsets(nums2);
        System.out.println(subsets2); // Output: [[],[0]]
    }
}
