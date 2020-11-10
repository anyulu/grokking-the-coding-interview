import java.util.*;

class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        // TODO: Write your code here
        k = Math.min(k, nums1.length*nums2.length);
        if (k == 0) return result;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> nums1[b[0]]+nums2[b[1]]-nums1[a[0]]-nums2[a[1]]);
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{i,0});
        }
        while (k > 0) {
            int[] index = queue.poll();
            result.add(new int[]{nums1[index[0]], nums2[index[1]]});
            k--;
            if (index[1]+1 < nums2.length) queue.add(new int[]{index[0], index[1]+1});
        }
        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
