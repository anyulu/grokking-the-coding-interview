class SubsetSumCount {
    static int countSubsets(int[] num, int sum) {
        //TODO: Write - Your - Code
        int n = num.length;
        int[] dp = new int[sum + 1];
        if (sum >= num[0]) dp[num[0]] = 1;
        dp[0] = 1;
        for(int i=1; i < num.length; i++) {
            for(int s=sum; s >= 0; s--) {
                if(s >= num[i]) dp[s] += dp[s-num[i]];
            }
        }
        return dp[sum];
    }
}