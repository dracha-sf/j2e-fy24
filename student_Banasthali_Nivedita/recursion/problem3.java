/*
The head of a singly linked-list is given. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
The values in the list's nodes may not be modified, only nodes themselves may be changed.
*/
package salesforce.recursion;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class problem3 {
    public static void orderLL(ListNode head) {
        
        //return if list is empty
        if (head == null || head.next == null) {
            return;
        }

        //Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half of the linked list
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // Merge the first half and the reversed second half of the linked list alternately
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf.next != null) {
            ListNode firstNext = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = firstNext;

            ListNode secondNext = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = secondNext;
        }
    }

    public static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before reordering:");
        display(head);

        orderLL(head);

        System.out.println("After reordering:");
        display(head);
    }
}
