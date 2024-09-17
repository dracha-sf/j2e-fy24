/*
EVALUATE THE VALUE OF AN ARITHMETIC EXPRESSION IN REVERSE POLISH NOTATION (RPN). VALID
OPERATORS ARE +, -, *, AND /. EACH OPERAND MAY BE AN INTEGER OR ANOTHER EXPRESSION.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem10 {
    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
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

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(evaluate(tokens1));  // Output: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evaluate(tokens2));  // Output: 6
    }
}
