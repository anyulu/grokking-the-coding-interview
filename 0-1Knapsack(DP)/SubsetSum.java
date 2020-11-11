class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
        // TODO: Write your code here
        int res = 0;
        for (int i: num) res += i;
        if (res < sum) return false;
        boolean[][] dp= new boolean[num.length][sum+1];
        for (int i = 0; i < num.length; i++) dp[i][0] = true;
        if (num[0] <= sum) dp[0][num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (j < num[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-num[i]];
                if (j == sum && dp[i][j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}