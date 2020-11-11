class TargetSum {

    public int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        int sum = 0;
        for (int i: num) sum += i;
        if (sum < s) return 0;
        int[][] dp = new int[num.length+1][2*sum+1];
        dp[0][sum+num[0]] += 1;
        dp[0][sum-num[0]] += 1;
        for (int i = 0; i < num.length-1; i++) {
            for (int j = 0; j <= 2*sum; j++) {
                if (dp[i][j] == 0) continue;
                if (j-sum + num[i+1] <= sum) dp[i+1][j+num[i+1]] += dp[i][j];
                if (j-sum - num[i+1] >= -sum) dp[i+1][j-num[i+1]] += dp[i][j];
            }
        }
        return dp[num.length-1][s+sum];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
