import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here
        if (p == q) return head;
        ListNode headCopy = head;
        ListNode prev = null, curr = head;
        int i = 1;
        while (curr != null & i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode start = prev;
        ListNode end = curr;
        prev = null;
        for (i = 0; curr != null & i < q-p+1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if (start != null) start.next = prev;
        else headCopy = prev;
        end.next = curr;
        return headCopy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}