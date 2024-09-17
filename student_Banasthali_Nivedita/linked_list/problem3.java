/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the
values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
package salesforce.linkedLists;

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int val) {
        this.val = val;
    }
}

public class problem3 {
    public static ListNode3 swapPairs(ListNode3 head) {
        
        //List has zero or one node
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode3 firstNode = head;
        ListNode3 secondNode = head.next;
        
        // Swap the two adjacent nodes
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode; // Return the new head of the swapped pairs
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(3);
        head.next.next.next = new ListNode3(4);

        ListNode3 swappedList = swapPairs(head);

        // Print the swapped list
        while (swappedList != null) {
            System.out.print(swappedList.val + " ");
            swappedList = swappedList.next;
        }
    }
}

