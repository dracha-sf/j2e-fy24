package stackandqueueassignment;
import java.util.*;
public class Problem8 
{
    public static String removeDuplicates(String s) 
    {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) 
        {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) 
            {
                stack.pop();
            } 
            else 
            {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) 
        {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = sc.next();
        String result = removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
        // Expected output: "ca"
    }
}
