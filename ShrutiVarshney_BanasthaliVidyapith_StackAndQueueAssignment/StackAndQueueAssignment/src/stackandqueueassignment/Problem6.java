package stackandqueueassignment;
import java.util.*;
public class Problem6 
{
    public static boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) 
        {
            if (c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            } 
            else
            {
                if (stack.isEmpty()) 
                {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) 
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) 
    {
        String input1 = "()[]{}";
        boolean result1 = isValid(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + result1);
        // Expected output: True

        String input2 = "([)]";
        boolean result2 = isValid(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + result2);
        // Expected output: False
    }
}
