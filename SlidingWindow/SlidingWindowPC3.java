import java.util.*;

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        if (str.length() < pattern.length()) return "";
        int start = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int res1 = -1;
        int res2 = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar)-1);
                if (map.get(currChar) == 0) count++;
            }
            while (count == map.size()) {
                char prevChar = str.charAt(start);
                if (map.containsKey(prevChar)) {
                    if (map.get(prevChar) == 0) {
                        count--;
                        if (min > end-start+1) {
                            min = end-start+1;
                            res1 = start;
                            res2 = end;
                        }
                    }
                    map.put(prevChar, map.get(prevChar)+1);
                }
                start++;
            }
        }
        return res1 != -1 ? str.substring(res1, res2+1) : "";
    }
}
