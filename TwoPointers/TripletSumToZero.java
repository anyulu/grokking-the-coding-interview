import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        if (arr.length < 3) return triplets;
        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[start] + arr[end] + arr[i] == 0){
                    triplets.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                    while (start < end && arr[start] == arr[start-1]) start++;
                    while (start < end && arr[end] == arr[end+1]) end--;
                }
                else if (arr[start]+arr[end]+arr[i] < 0) start++;
                else end--;
            }
        }
        return triplets;
    }
}
