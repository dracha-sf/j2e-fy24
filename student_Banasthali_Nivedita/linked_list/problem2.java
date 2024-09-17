/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
 */
package salesforce.linkedLists;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }
}

public class problem2 {
    public static ListNode2 mergeLists(ListNode2 l1, ListNode2 l2) {
        
        // Dummy node to handle edge cases
        ListNode2 dummy = new ListNode2(0); 
        ListNode2 current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Append the remaining nodes of list1 or list2
        if (l1 != null) {
            current.next = l1;
        }
        
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next; // Return the head of the merged list
    }

    public static void main(String[] args) {
        // Create the first sorted linked list: 1 -> 2 -> 4
        ListNode2 list1 = new ListNode2(1);
        list1.next = new ListNode2(2);
        list1.next.next = new ListNode2(4);

        // Create the second sorted linked list: 1 -> 3 -> 4
        ListNode2 list2 = new ListNode2(1);
        list2.next = new ListNode2(3);
        list2.next.next = new ListNode2(4);

        ListNode2 mergedList = mergeLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
