class LRS {

    public int findLRSLength(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLRSLengthRecursive(dp, str, 0, 0);
    }

    private int findLRSLengthRecursive(Integer[][] dp, String str, int i1, int i2) {
        if(i1 == str.length() || i2 == str.length())
            return 0;

        if(dp[i1][i2] == null) {
            if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
                dp[i1][i2] = 1 + findLRSLengthRecursive(dp, str, i1+1, i2+1);
            else {
                int c1 = findLRSLengthRecursive(dp, str, i1, i2+1);
                int c2 = findLRSLengthRecursive(dp, str, i1+1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    public static void main(String[] args) {
        LRS lrs = new LRS();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }
}

// option 2
class LRS {

    public int findLRSLength(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];
        int maxLength = 0;
        for(int i1=1; i1 <= str.length(); i1++) {
            for(int i2=1; i2 <= str.length(); i2++) {
                if(i1 != i2 && str.charAt(i1-1) == str.charAt(i2-1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);

                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LRS lrs = new LRS();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }
}
