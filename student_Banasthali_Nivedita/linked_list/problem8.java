/*
You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the a
th node to the b
th node, and put list2 in their place.
The blue edges and nodes in the following figure indicate the result:
Build the result list and return its head.
 */
package salesforce.linkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class problem8 {
    public ListNode mergeLists(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev = dummy;

        // Move prev to the (a-1)th node
        for (int i = 0; i < a - 1; i++) {
            prev = prev.next;
        }

        // Remove nodes from a to b
        ListNode current = prev.next;
        for (int i = 0; i < b - a; i++) {
            current = current.next;
        }
        prev.next = current;

        // Find the last node of list2
        ListNode lastNode = list2;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        // Insert list2 after prev
        ListNode temp = prev.next;
        prev.next = list2;
        lastNode.next = temp;

        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        problem8 merger = new problem8();

        // Example 1
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        
        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);

        int a = 3;
        int b = 4;

        ListNode mergedList = merger.mergeLists(list1, a, b, list2);
        merger.printList(mergedList);
    }
}


