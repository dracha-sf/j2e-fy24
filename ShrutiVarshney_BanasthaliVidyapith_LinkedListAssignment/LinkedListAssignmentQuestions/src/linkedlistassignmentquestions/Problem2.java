package linkedlistassignmentquestions;
public class Problem2 
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) 
        {
            if (list1.val <= list2.val) 
            {
                current.next = list1;
                list1 = list1.next;
            } 
            else 
            {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from list1 or list2
        if (list1 != null)
        {
            current.next = list1;
        }
        if (list2 != null)
        {
            current.next = list2;
        }

        return dummy.next;
    }
    public static void main(String[] args)
    {
        // Create two sorted linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Problem2 merger = new Problem2();
        ListNode mergedList = merger.mergeTwoLists(list1, list2);

        // Print the merged list
        ListNode current = mergedList;
        while (current != null) 
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
