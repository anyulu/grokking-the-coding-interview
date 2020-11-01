import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        // TODO: Write your code here
        if (head == null || rotations == 0) return head;
        ListNode prev = null, curr = head, start = head;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        int rot = len - rotations % len;
        if (rot == len) return curr;
        while (rot > 0) {
            prev = curr;
            curr = curr.next;
            rot--;
        }
        head.next = start;
        prev.next = null;
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}