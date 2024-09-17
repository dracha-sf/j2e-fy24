/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
package salesforce.linkedLists;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
    }
}

public class problem1 {
    public static ListNode1 removeNode(ListNode1 head, int n) {
        
        // Dummy node to handle edge cases
        ListNode1 dummy = new ListNode1(0); 
        dummy.next = head;
        
        ListNode1 slow = dummy;
        ListNode1 fast = dummy;
        
        // Move the fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers together until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Skip the n-th node from the end
        slow.next = slow.next.next;
        
        return dummy.next; // Return the updated head
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);

        int n = 2;

        ListNode1 result = removeNode(head, n);

        // Print the resulting linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

