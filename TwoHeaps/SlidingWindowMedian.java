import java.util.*;

class SlidingWindowMedian {
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>((Collections.reverseOrder()));

    private void insert(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add((double)num);
        else minHeap.add((double)num);
        if (maxHeap.size() > minHeap.size()+1) minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
    }

    private double getMedian() {
        if (maxHeap.size() == minHeap.size()) return (double) (maxHeap.peek()+minHeap.peek())/2;
        else return (double) maxHeap.peek();
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // TODO: Write your code here
        for (int i = 0; i < k-1; i++) insert(nums[i]);
        for (int i = k-1; i < nums.length; i++) {
            insert(nums[i]);
            result[i-k+1] = getMedian();
            double num = nums[i-k+1];
            if (maxHeap.contains(num)) {
                maxHeap.remove(num);
                if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
            } else {
                minHeap.remove(num);
                if (maxHeap.size() > minHeap.size()+1) minHeap.add(maxHeap.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}