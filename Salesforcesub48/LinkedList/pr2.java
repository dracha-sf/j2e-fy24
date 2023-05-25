import java.util.Scanner;

public class pr2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static ListNode insert(ListNode head, int data) {
        ListNode new_node = new ListNode(data);
        if (head == null) {
            head = new_node;
        } else {
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode list = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list = insert(list, x);
        }
        int m = sc.nextInt();
        ListNode list1 = null;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            list1 = insert(list1, x);
        }
        pr2 merger = new pr2();
        ListNode mergedList = merger.mergeTwoLists(list1, list);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}
