import java.util.*;

class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        // TODO: Write your code here
        if (arr.length < 4) return quadruplets;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-3; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            find(quadruplets, arr, target-arr[i], i);
        }
        return quadruplets;
    }

    private static void find(List<List<Integer>> quadruplets, int[] arr, int target, int curr) {
        for (int i = curr+1; i < arr.length-2; i++) {
            if (i > curr+1 && arr[i] == arr[i-1]) continue;
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[start]+arr[end]+arr[i] == target) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr[curr], arr[i],arr[start++],arr[end--]));
                    while (start < end && arr[start] == arr[start-1]) start++;
                    while (start < end && arr[end] == arr[end+1]) end--;
                    quadruplets.add(temp);
                } else if (arr[start]+arr[end]+arr[i] < target) start++;
                else end--;
            }
        }
        return;
    }
}