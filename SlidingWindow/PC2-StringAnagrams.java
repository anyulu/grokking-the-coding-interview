import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        if (str.length() < pattern.length()) return resultIndices;
        int size = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar)-1);
                if (map.get(currChar) == 0) size++;
            }
            if (size == map.size()) resultIndices.add(start);
            if (end-start+1 == pattern.length()) {
                char startChar = str.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) size--;
                    map.put(startChar, map.get(startChar)+1);
                }
                start++;
            }
        }
        return resultIndices;
    }
}
