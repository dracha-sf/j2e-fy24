package recursionassignmentquestions;
class ListNode 
{
    int val;
    ListNode next;

    ListNode(int val) 
    {
        this.val = val;
    }
}
public class Problem3 
{
     public void reorderList(ListNode head) 
     {
        if (head == null || head.next == null || head.next.next == null) 
        {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode reversed = reverseList(mid.next);
        mid.next = null;

        mergeLists(head, reversed);
    }

    private ListNode findMiddle(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) 
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) 
    {
        while (l1 != null && l2 != null) 
        {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
    public static void main(String[] args) 
    {
        // Example 1: [1,2,3,4]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        Problem3 solution = new Problem3();
        solution.reorderList(head1);
        printList(head1); // Output: 1 -> 4 -> 2 -> 3

        // Example 2: [1,2,3,4,5]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        solution.reorderList(head2);
        printList(head2); // Output: 1 -> 5 -> 2 -> 4 -> 3
    }

    private static void printList(ListNode head) 
    {
        ListNode current = head;
        while (current != null) 
        {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

