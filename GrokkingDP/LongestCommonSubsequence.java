class LCS {

    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0;
        for(int i=1; i <= s1.length(); i++) {
            for(int j=1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}

// O(n) space
class LCS {
    static int findLCSLength(String s1, String s2) {
        //TODO: Write - Your - Code
        int[] dp = new int[s1.length()+1];
        for (int j = 0; j < s2.length(); j++) {
            for (int i = 1; i <= s1.length(); i++) {
                if (s1.charAt(i-1) == s2.charAt(j)) dp[i] = 1+dp[i-1];
                else dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }
        return dp[s1.length()];
    }
}