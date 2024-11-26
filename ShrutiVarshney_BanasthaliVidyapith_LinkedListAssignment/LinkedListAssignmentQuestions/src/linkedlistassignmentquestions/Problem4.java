package linkedlistassignmentquestions;
public class Problem4 
{
     public static void main(String[] args) 
     {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head);

        ListNode uniqueHead = deleteDuplicates(head);

        System.out.println("List with Duplicates Removed:");
        printList(uniqueHead);
    }

    public static ListNode deleteDuplicates(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) 
        {
            if (current.val == current.next.val) 
            {
                current.next = current.next.next;
            } 
            else 
            {
                current = current.next;
            }
        }

        return head;
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
   
