class PartitionSet {

    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int res = 0;
        for (int i: num) res += i;
        if (res % 2 == 1) return false;
        res /=2;
        boolean[] dp = new boolean[res+1];
        if (res >= num[0]) dp[num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = res; j >= 0; j--) {
                if (j >= num[i]) dp[j] = dp[j] || dp[j-num[i]];
            }
        }
        return dp[res];
    }
}