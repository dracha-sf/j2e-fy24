package linkedlistassignmentquestions;
public class Problem8 
{
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode start = list1;
        for (int i = 0; i < a - 1; i++) 
        {
            start = start.next;
        }
        
        ListNode end = start;
        for (int i = 0; i < b - a + 2; i++) 
        {
            end = end.next;
        }
        
        start.next = list2;
        ListNode list2End = list2;
        while (list2End.next != null) 
        {
            list2End = list2End.next;
        }
        list2End.next = end;
        
        return list1;
    }
    
    public static void main(String[] args) 
    {
        // Test case 1
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        
        int a = 3;
        int b = 4;
        
        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        
        Problem8 solution = new Problem8();
        ListNode mergedList = solution.mergeInBetween(list1, a, b, list2);
        printLinkedList(mergedList);
        
        // Test case 2
        ListNode list3 = new ListNode(0);
        list3.next = new ListNode(1);
        list3.next.next = new ListNode(2);
        list3.next.next.next = new ListNode(3);
        list3.next.next.next.next = new ListNode(4);
        list3.next.next.next.next.next = new ListNode(5);
        list3.next.next.next.next.next.next = new ListNode(6);
        
        int a2 = 2;
        int b2 = 5;
        
        ListNode list4 = new ListNode(1000000);
        list4.next = new ListNode(1000001);
        list4.next.next = new ListNode(1000002);
        list4.next.next.next = new ListNode(1000003);
        list4.next.next.next.next = new ListNode(1000004);
        
        ListNode mergedList2 = solution.mergeInBetween(list3, a2, b2, list4);
        printLinkedList(mergedList2);
    }
    
    private static void printLinkedList(ListNode head) 
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
