/*
GIVEN A STRING CONTAINING ONLY PARENTHESES, DETERMINE IF THE STRING IS VALID. AN INPUT
STRING IS VALID IF:
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem6 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket, push onto the stack
                stack.push(c);
            } else {
                // Closing bracket
                if (stack.isEmpty()) {
                    // No corresponding opening bracket
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    // Mismatched closing bracket
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";

        boolean isValid1 = isValid(s1);
        boolean isValid2 = isValid(s2);

        System.out.println(isValid1); // Output: true
        System.out.println(isValid2); // Output: false
    }
}
