import java.util.*;

class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        // TODO: Write your code here
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (Integer[] list: lists) {
            int n = list.length;
            for (int i = 0; i < n; i++) {
                if (queue.size() == k) {
                    int temp = queue.poll();
                    if (list[i] < temp) queue.add(list[i]);
                    else queue.add(temp);
                } else queue.add(list[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
