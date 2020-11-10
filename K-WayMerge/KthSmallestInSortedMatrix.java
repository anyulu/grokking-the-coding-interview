import java.util.*;

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here
        int n = matrix.length;
        int len = matrix[0].length;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (queue.size() == k) {
                    int num = queue.poll();
                    if (matrix[i][j] < num) queue.add(matrix[i][j]);
                    else queue.add(num);
                } else queue.add(matrix[i][j]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}

// binary search
import java.util.*;

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        while (start < end) {
            int mid = start+(end-start)/2;
            int[] pair = new int[]{start, end};
            int count = count(matrix, mid, pair);
            if (count == k) return pair[0];
            if (count < k) start = pair[1];
            else end = pair[0];
        }
        return -1;
    }

    private static int count(int[][] matrix, int mid, int[] pair) {
        int row = matrix.length-1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= mid) {
                pair[0] = Math.max(matrix[row][col], pair[0]);
                count += (row+1);
                col++;
            } else {
                pair[1] = Math.min(matrix[row][col], pair[1]);
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
