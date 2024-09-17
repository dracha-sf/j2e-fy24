/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
original list. Return the linked list sorted as well.
 */
package salesforce.linkedLists;

class ListNode7 {
    int val;
    ListNode7 next;

    ListNode7(int val) {
        this.val = val;
    }
}

public class problem5 {
    public static ListNode7 deleteDuplicates(ListNode7 head) {
        
        // Create a dummy node to handle the edge case of deleting the head node
        ListNode7 dummy = new ListNode7(0);
        dummy.next = head;
        
        ListNode7 prev = dummy;
        ListNode7 current = head;
        
        while (current != null) {
            // Skip all the duplicate nodes
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            
            // Check if there are duplicates
            if (prev.next != current) {
                prev.next = current.next; // Remove the duplicate nodes
            } else {
                prev = prev.next; // Move to the next node
            }
            
            current = current.next; // Move to the next node
        }
        
        return dummy.next; // Return the head of the updated list
    }

    public static void main(String[] args) {
        // Create the sorted linked list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode7 head = new ListNode7(1);
        head.next = new ListNode7(2);
        head.next.next = new ListNode7(3);
        head.next.next.next = new ListNode7(3);
        head.next.next.next.next = new ListNode7(4);
        head.next.next.next.next.next = new ListNode7(4);
        head.next.next.next.next.next.next = new ListNode7(5);

        ListNode7 updatedList = deleteDuplicates(head);

        // Print the updated list
        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
        }
    }
}
