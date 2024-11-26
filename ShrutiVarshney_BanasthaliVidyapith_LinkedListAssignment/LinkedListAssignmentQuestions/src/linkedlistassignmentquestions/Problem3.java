package linkedlistassignmentquestions;
public class Problem3 
{
    public static void main(String[] args) 
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        ListNode swappedHead = swapPairs(head);

        System.out.println("Swapped List:");
        printList(swappedHead);
    }

    public static ListNode swapPairs(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swap the nodes
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public static void printList(ListNode head) 
    {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
