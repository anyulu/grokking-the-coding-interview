import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if (str.length() == 0 || k == 0) return 0;
        List<Character> set = new ArrayList<>();
        int start = 0;
        int res = Integer.MIN_VALUE;
        for (int end = 0; end < str.length(); end++) {
            if (set.contains(str.charAt(end))) {
                res = Math.max(res, end-start+1);
                set.remove(set.indexOf(str.charAt(end)));
                set.add(str.charAt(end));
            }
            else if (set.size() < k) {
                set.add(str.charAt(end));
                res = Math.max(res, end-start+1);
            } else {
                set.add(str.charAt(end));
                set.remove(0);
                start = end-1;
                while (set.contains(str.charAt(start))) start--;
                start++;
                res = Math.max(res, end-start+1);
            }
        }
        return res;
    }
}