package linkedlistassignmentquestions;
import java.util.*;
class ListNode
{
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class Problem1 
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // Create a dummy node to handle the case when the head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers, fast and slow, with a gap of n nodes
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n nodes ahead
        for (int i = 0; i <= n; i++) 
        {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end of the list
        while (fast != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end by adjusting pointers
        slow.next = slow.next.next;

        return dummy.next;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Enter the nth node to be removed from the end:");
        int n = sc.nextInt();

        Problem1 remover = new Problem1();
        head = remover.removeNthFromEnd(head, n);

        // Print the linked list after removing the nth node from the end
        ListNode current = head;
        while (current != null) 
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
