package stackandqueueassignment;
import java.util.*;
public class Problem7 
{
    public static int[] findNextGreaterElement(int[] nums) 
    {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) 
        {
            // Pop elements from the stack that are smaller than the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) 
            {
                stack.pop();
            }

            // Set the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element to the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int[] input1 = {4, 5, 2, 25};
        int[] result1 = findNextGreaterElement(input1);
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + Arrays.toString(result1));
        // Expected output: [5, 25, 25, -1]

        int[] input2 = {13, 7, 6, 12};
        int[] result2 = findNextGreaterElement(input2);
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + Arrays.toString(result2));
        // Expected output: [-1, 12, 12, -1]
    }
}
