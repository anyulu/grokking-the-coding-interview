class SubsetSum {

    static boolean canPartition(int[] num, int sum) {
        //TODO: Write - Your - Code
        int n = num.length;
        boolean[] dp = new boolean[sum + 1];
        if (sum >= num[0]) dp[num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (s >= num[i]) dp[s] = dp[s] || dp[s - num[i]];
            }
        }
        return dp[sum];
    }
}