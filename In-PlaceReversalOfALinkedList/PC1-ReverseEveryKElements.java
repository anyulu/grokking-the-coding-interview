import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        if (head == null || k <= 1) return head;
        ListNode prev = null, curr = head;
        ListNode start = prev, end = curr;
        boolean reverse = true;
        while (true) {
            start = prev;
            end = curr;
            if (reverse) {
                reverse = false;
                for (int i = 0; curr != null && i < k; i++) {
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                if (start != null) start.next = prev;
                else head = prev;
                end.next = curr;
                prev = end;
                if (curr == null) break;
            } else {
                reverse = true;
                ListNode temp = curr;
                for (int i = 0; curr != null && i < k; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                if (curr == null) {
                    curr = temp;
                    break;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}