/*
Parentheses strings are strings containing only the characters '(' and ')'. A parentheses string is considered balanced when its
opening parentheses align with its closing parentheses. For example, "()()" and "(()())" are balanced parentheses strings while
")(", "())(" are not.
Given a string consisting of the same number of opening and closing parentheses, determine the minimum number of
character swaps required to make the string a balanced parentheses string.
 */
package salesforce;

import java.util.Stack;

public class stringProblem5 {
     public static int minimum_no_of_swaps(String s) {
        int count = 0;
        
        //create a stack to store the index of characters of string
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            
            //we need to have an unbalanced expression of paractheses
            
            //push the open parantheses
            if (c == '(') {
                stack.push(i);
            }
            
            //if stack is not empty and there isn't an open parantheses at the top of the stack
            //then pop the current character, otherwise puch it into the stack
            else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } 
                
                else {
                    stack.push(i);
                }
            }
        }
        
        //size of stack gives number of unbalanced parantheses thus half the size of stack will
        //give us the swaps required to balance the string.
        count = stack.size() / 2;
        return count;
    }
    
    public static void main(String[] args) {
        String s = "))((";
        int result = minimum_no_of_swaps(s);
        System.out.println("Minimum number of swaps: " + result);
    }
}
