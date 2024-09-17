/*
Print sums of all subsets of a given set of size n.
 */
package salesforce.recursion;

import java.util.*;

public class problem5 {
    public static void sum_of_subsets(int[] arr) {
        
        //form a list to store the subsets
        List<Integer> subsets = new ArrayList<>();
        subsetSumRecr(arr, 0, 0, subsets);

        // Print the sums of all subsets
        for (int sum : subsets) {
            System.out.print(sum + " ");
        }
    }

    private static void subsetSumRecr(int[] arr, int index, int currentSum, List<Integer> subsets) {
        int n = arr.length;

        if (index == n) {
            subsets.add(currentSum); // Add the current sum to the list of subsets
            return;
        }

        // Include the current element in the subset and recursively process the next element
        subsetSumRecr(arr, index + 1, currentSum + arr[index], subsets);

        // Exclude the current element from the subset and recursively process the next element
        subsetSumRecr(arr, index + 1, currentSum, subsets);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5};
        sum_of_subsets(arr);
    }
}
