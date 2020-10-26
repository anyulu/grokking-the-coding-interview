import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        // TODO: Write your code here
        if (str.length() <= 1) return str.length();
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (map.containsKey(currChar)) start = Math.max(start, map.get(currChar)+1);
            map.put(currChar, end);
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
