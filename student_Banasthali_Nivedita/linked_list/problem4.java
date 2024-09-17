/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list
sortedas well.
 */
package salesforce.linkedLists;

class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4(int val) {
        this.val = val;
    }
}

public class problem4 {
    public static ListNode4 deleteDuplicateNodes(ListNode4 head) {
        ListNode4 current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Remove the duplicate node
            } else {
                current = current.next; // Move to the next node
            }
        }
        
        return head; // Return the head of the updated list
    }

    public static void main(String[] args) {
        // Create the sorted linked list: 1 -> 1 -> 2
        ListNode4 head = new ListNode4(1);
        head.next = new ListNode4(1);
        head.next.next = new ListNode4(2);

        ListNode4 updatedList = deleteDuplicateNodes(head);

        // Print the updated list
        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
        }
    }
}
