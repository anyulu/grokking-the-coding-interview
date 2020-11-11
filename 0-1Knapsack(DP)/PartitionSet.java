class PartitionSet {

    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++) sum += num[i];
        if ( sum%2 != 0 || num.length <=1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[num.length][sum+1];
        if (num[0] <= sum) dp[0][num[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                    if (j+num[i] < sum+1) dp[i][j+num[i]] = true;
                }
            }
        }
        return dp[num.length-1][sum];
    }
}