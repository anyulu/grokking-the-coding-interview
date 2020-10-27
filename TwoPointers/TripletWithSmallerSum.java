import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        // TODO: Write your code here
        if (arr.length < 3) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[i]+arr[start]+arr[end] < target) {
                    count += (end-start);
                    start++;
                } else end--;
            }
        }
        return count;
    }
}