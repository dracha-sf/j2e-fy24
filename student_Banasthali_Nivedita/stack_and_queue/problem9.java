/*
WRITE A CLASS STOCKSPANNER WHICH COLLECTS DAILY PRICE QUOTES FOR SOME STOCK, AND
RETURNS THE SPAN OF THAT STOCK'S PRICE FOR THE CURRENT DAY. THE SPAN OF THE STOCK'S PRICE TODAY IS
DEFINED AS THE MAXIMUM NUMBER OF CONSECUTIVE DAYS (STARTING FROM TODAY AND GOING BACKWARDS)
FOR WHICH THE PRICE OF THE STOCK WAS LESS THAN OR EQUAL TO TODAY'S PRICE.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem9 {
    private Stack<Integer> prices;
    private Stack<Integer> spans;

    public problem9() {
        prices = new Stack<>();
        spans = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            span += spans.pop();
        }

        prices.push(price);
        spans.push(span);

        return span;
    }

    public static void main(String[] args) {
        problem9 stockSpanner = new problem9();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}
