import java.util.*;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here
        if (arr.length < 3) return -1;
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                int diff = targetSum - arr[i]-arr[start]-arr[end];
                if (diff == 0) return targetSum;
                if (diff > 0) start++;
                else end--;
                if (Math.abs(diff) < Math.abs(res)) res = diff;
            }
        }
        return targetSum-res;
    }
}