class LCS {

    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0;
        for(int i=1; i <= s1.length(); i++) {
            for(int j=1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.findLCSLength("abcd", "abcaabcd"));
    }
}

// O(n) space
class LCS {

    static int findLCSLength(String s1, String s2) {
        //TODO: Write - Your - Code
        int[] dp = new int[s2.length()+1];
        int max = -1;
        int index = s1.length()-1;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = s2.length(); j >= 1; j--) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = 1+dp[j-1];
                    max = Math.max(max, dp[j]);
                } else dp[j] = 0;
            }
        }
        return max;
    }
}
