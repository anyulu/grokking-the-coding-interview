import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        // TODO: Write your code here
        Queue<Integer> queue = new PriorityQueue<Integer>((a,b) -> intervals[a].start-intervals[b].start);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Queue<Integer> temp = new PriorityQueue<>(queue);
            while (true) {
                if (temp.isEmpty()) {
                    result[i] = -1;
                    break;
                }
                if (temp.peek() == i) temp.poll();
                else if (intervals[temp.peek()].start < intervals[i].end) temp.poll();
                else {
                    result[i] = temp.peek();
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}

// lc 436
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Queue<Integer> startHeap = new PriorityQueue<Integer>(
            (a,b) -> intervals[a][0]-intervals[b][0]);
        Queue<Integer> endHeap = new PriorityQueue<Integer>(
            (a,b) -> intervals[a][1]-intervals[b][1]);
        for (int i = 0; i < intervals.length; i++) {
            startHeap.add(i);
            endHeap.add(i);
            result[i] = -1;
        }
        while (!endHeap.isEmpty()) {
            int curr = endHeap.poll();
            while (!startHeap.isEmpty()) {
                if (intervals[startHeap.peek()][0] >= intervals[curr][1]) {
                    result[curr] = startHeap.peek();
                    break;
                } else startHeap.poll();
            }
        }
        return result;
    }
}