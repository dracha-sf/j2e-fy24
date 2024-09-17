/*
GIVEN A STRING S CONSISTING OF LOWERCASE LETTERS, REMOVE ADJACENT DUPLICATES FROM S.
THE FINAL OUTPUT SHOULD BE IN LEXICOGRAPHICALLY SMALLEST ORDER.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem8 {
    public static String remove_adjacent_duplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String result = remove_adjacent_duplicates(s);
        System.out.println(result); // Output: "ca"
    }
}
