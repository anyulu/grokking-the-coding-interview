import java.util.*;

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        // TODO: Write your code here
        if (arr.length <= 2) return arr.length;
        int count = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            count++;
            map.put(arr[end], map.getOrDefault(arr[end],0)+1);
            while (map.size() > 2) {
                map.put(arr[start], map.get(arr[start])-1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                count--;
                start++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
