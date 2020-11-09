import java.util.*;

class KthLargestNumberInStream {
    Queue<Integer> queue = new PriorityQueue<>();
    int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        // TODO: Write your code here
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
    }

    public int add(int num) {
        // TODO: Write your code here
        queue.add(num);
        while (queue.size() > this.k) queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}