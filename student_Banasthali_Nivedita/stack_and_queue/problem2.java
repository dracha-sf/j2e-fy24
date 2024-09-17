/*
IMPLEMENT A QUEUE USING 2 STACKS S1 AND S2 
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem2 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Function to push an element to the queue
    void enqueue(int x) {
        // Push the element onto s1
        s1.push(x);
    }

    // Function to remove the front element from the queue
    int dequeue() {
        // If both stacks are empty, the queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1; // or throw an exception
        }

        // If s2 is empty, transfer elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Pop and return the top element from s2
        return s2.pop();
    }

    public static void main(String[] args) {
        problem2 queue = new problem2();
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Output: 3
    }
}


/*
import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Function to push an element to the queue
    void enqueue(int x) {
        // Push the element onto s1
        s1.push(x);
    }

    // Function to remove the front element from the queue
    int dequeue() {
        // If both stacks are empty, the queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1; // or throw an exception
        }

        // If s2 is empty, transfer elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Pop and return the top element from s2
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Output: 3
    }
}




import java.util.*;

class MaximumOfSubarrays {
    static void findMaximums(int[] arr, int N, int K) {
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for (i = 0; i < K; i++) {
            // Remove elements smaller than the current element from the deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process the remaining elements
        for (; i < N; i++) {
            // The front element of the deque is the maximum for the previous window
            System.out.print(arr[deque.peekFirst()] + " ");

            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.removeFirst();
            }

            // Remove elements smaller than the current element from the deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print the maximum for the last window
        System.out.print(arr[deque.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int N = 9;
        int K = 3;
        findMaximums(arr, N, K);
    }
}





import java.util.HashMap;
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
            if (cache.size() > capacity) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                cache.remove(tailNode.key);
            }
        }
    }
}





import java.util.*;

class DeckArrangement {
    public static List<Integer> arrangeDeck(int N) {
        List<Integer> deck = new ArrayList<>();

        // Initialize the deck with numbers from 1 to N
        for (int i = 1; i <= N; i++) {
            deck.add(i);
        }

        // Perform the process step by step
        int i = 1;
        while (deck.size() > 1) {
            // Move the first card to the end of the deck
            deck.add(deck.remove(0));

            // Remove the ith card from the deck
            int card = deck.remove(0);
            if (card == i) {
                // If the removed card is equal to i, increment i
                i++;
            } else {
                // If the removed card is not equal to i, it's not possible
                return Collections.singletonList(-1);
            }
        }

        return deck;
    }

    public static void main(String[] args) {
        int N = 4;
        List<Integer> arrangement = arrangeDeck(N);
        System.out.println(arrangement);
    }
}




import java.util.Stack;

class ValidParentheses {
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





import java.util.*;

class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than nums[i]
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // Set the next greater element
            if (stack.isEmpty()) {
                result[i] = -1; // No greater element on the right
            } else {
                result[i] = stack.peek();
            }

            // Push nums[i] onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 2, 25};
        int[] nums2 = {13, 7, 6, 12};

        int[] result1 = nextGreaterElement(nums1);
        int[] result2 = nextGreaterElement(nums2);

        System.out.println(Arrays.toString(result1)); // Output: [5, 25, 25, -1]
        System.out.println(Arrays.toString(result2)); // Output: [-1, 12, 12, -1]
    }
}




import java.util.*;

class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than nums[i]
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // Set the next greater element
            if (stack.isEmpty()) {
                result[i] = -1; // No greater element on the right
            } else {
                result[i] = stack.peek();
            }

            // Push nums[i] onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 2, 25};
        int[] nums2 = {13, 7, 6, 12};

        int[] result1 = nextGreaterElement(nums1);
        int[] result2 = nextGreaterElement(nums2);

        System.out.println(Arrays.toString(result1)); // Output: [5, 25, 25, -1]
        System.out.println(Arrays.toString(result2)); // Output: [-1, 12, 12, -1]
    }
}




import java.util.Stack;

class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s) {
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
        String result = removeDuplicates(s);
        System.out.println(result); // Output: "ca"
    }
}




import java.util.Stack;

class StockSpanner {
    private Stack<Integer> prices;
    private Stack<Integer> spans;

    public StockSpanner() {
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
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}





import java.util.Stack;

class EvaluateRPN {
    public static int evalRPN(String[] tokens) {
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
               



import java.util.Stack;

class EvaluateRPN {
    public static int evalRPN(String[] tokens) {
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
        System.out.println(evalRPN(tokens1));  // Output: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));  // Output: 6
    }
}





*/