package stackandqueueassignment;
import java.util.*;
public class Problem10 
{
    public static int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) 
        {
            if (isOperator(token)) 
            {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluateExpression(token, operand1, operand2);
                stack.push(result);
            } 
            else 
            {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token)
    {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int evaluateExpression(String operator, int operand1, int operand2) {
        switch (operator) 
        {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    public static void main(String[] args)
    {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens1)); // Output: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2)); // Output: 6
    }
}
