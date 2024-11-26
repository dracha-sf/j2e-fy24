package stackandqueueassignment;
import java.util.*;
public class Problem5 
{
    public int[] rotation(int N) 
    {
        if (N <= 0) 
        {
            return new int[0];
        }

        int[] deck = new int[N];
        Stack<Integer> stack = new Stack<>();

        // Initialize the deck in ascending order
        for (int i = 0; i < N; i++) 
        {
            deck[i] = i + 1;
        }

        // Simulate the process
        for (int i = 0; i < N; i++) 
        {
            stack.push(deck[i]);
            stack.push(stack.pop());
        }

        // Prepare the result array
        int[] result = new int[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            result[i] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        Problem5 solution = new Problem5();

        // Test Case 1
        int N1 = 4;
        int[] result1 = solution.rotation(N1);
        System.out.println("Output for N = " + N1 + ":");
        if (result1.length == 0) {
            System.out.println("-1");
        } else {
            for (int num : result1) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Test Case 2
        int N2 = 5;
        int[] result2 = solution.rotation(N2);
        System.out.println("Output for N = " + N2 + ":");
        if (result2.length == 0) {
            System.out.println("-1");
        } else {
            for (int num : result2) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
