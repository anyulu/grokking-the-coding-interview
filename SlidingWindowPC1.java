import java.util.*;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here
        if (str.length() < pattern.length()) return false;
        int start = 0;
        boolean res = false;
        String curr = "";
        for (int end = 0; end < str.length(); end++) {
            curr += str.charAt(end);
            if (end-start+1 >= pattern.length()) {
                res = permutation(curr, pattern);
                if (res) return true;
                curr = curr.substring(1);
                start++;
            }
        }
        return false;
    }

    private static boolean permutation(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) return false;
        }
        return true;
    }
}
