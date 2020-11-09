import java.util.*;
import java.util.stream.Collectors;

class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        // TODO: Write your code here
        if (nums.length <= k) return Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) queue.add(nums[i]);
        while (k-- > 0) result.add(queue.poll());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
