
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {

    public static void reorder(ListNode head) {
        // TODO: Write your code here
        ListNode fast = head, slow = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            len += 2;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) len--;
        ListNode copy = head;
        ListNode reverseHalf = reverse(slow);
        int count = 0;
        while (count < len/2) {
            count++;
            ListNode temp = head.next;
            head.next = reverseHalf;
            reverseHalf = reverseHalf.next;
            head = head.next;
            head.next = temp;
            head = head.next;
        }
        head = copy;
        return;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}