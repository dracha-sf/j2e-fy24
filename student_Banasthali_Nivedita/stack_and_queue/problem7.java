/*
GIVEN AN ARRAY, FIND THE NEXT GREATER ELEMENT (NGE) FOR EVERY ELEMENT IN THE ARRAY. THE
NEXT GREATER ELEMENT FOR AN ELEMENT X IS THE FIRST GREATER ELEMENT ON THE RIGHT SIDE OF X IN THE
ARRAY. IF THERE IS NO GREATER ELEMENT ON THE RIGHT SIDE, THEN THE OUTPUT FOR THAT ELEMENT SHOULD
BE -1.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem7 {
     public static int[] next_great_element(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than nums[i]
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // Set the next greater element
            if (stack.isEmpty()) {
                result[i] = -1; // No greater element on the right
            } else {
                result[i] = stack.peek();
            }

            // Push nums[i] onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {13,7,6,12};
        int[] nums2 = {4,5,2,25};

        int[] result1 = next_great_element(nums1);
        int[] result2 = next_great_element(nums2);

        System.out.println(Arrays.toString(result1)); // Output: [5, 25, 25, -1]
        System.out.println(Arrays.toString(result2)); // Output: [-1, 12, 12, -1]
    }
}
