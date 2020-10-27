import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here
        if (arr.length == 0) return subarrays;
        for (int i = 0; i < arr.length; i++) {
            int end = i+1;
            int prod = arr[i];
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            while (prod < target) {
                subarrays.add(new ArrayList<>(temp));
                if (end < arr.length) {
                    temp.add(arr[end]);
                    prod *= arr[end++];
                }
                else break;
            }
        }
        return subarrays;
    }
}
