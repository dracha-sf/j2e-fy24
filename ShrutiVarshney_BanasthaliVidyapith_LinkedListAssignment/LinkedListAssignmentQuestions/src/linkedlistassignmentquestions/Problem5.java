package linkedlistassignmentquestions;
public class Problem5 
{
    public static void main(String[] args) 
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ListNode distinctHead = deleteDuplicates(head);

        System.out.println("List with Duplicates Removed:");
        printList(distinctHead);
    }

    public static ListNode deleteDuplicates(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) 
        {
            while (current.next != null && current.val == current.next.val) 
            {
                current = current.next;
            }

            if (prev.next == current) 
            {
                prev = prev.next;
            } 
            else
            {
                prev.next = current.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) 
    {
        ListNode current = head;
        while (current != null) 
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
