class SubsetSum {
    static int countSubsets(int[] num, int sum) {
        //TODO: Write - Your - Code
        int total = 0;
        int count = 0;
        for (int i: num) total += i;
        if (total < sum) return 0;
        int[][] dp = new int[num.length][sum+1];
        for (int i = 0; i < num.length; i++) dp[i][0] = 1;
        if (num[0] <= sum) dp[0][num[0]] = 1;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= num[i]) dp[i][j] = dp[i-1][j] + dp[i-1][j-num[i]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[num.length-1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}