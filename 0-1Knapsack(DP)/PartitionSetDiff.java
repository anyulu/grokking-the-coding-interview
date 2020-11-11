class PartitionSet {

    public int canPartition(int[] num) {
        // TODO: Write your code here
        int sum = 0;
        for (int i: num) sum += i;
        boolean[][] dp= new boolean[num.length][sum/2+1];
        for (int i = 0; i < num.length; i++) dp[i][0] = true;
        if (num[0] <= sum/2) dp[0][num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum/2 + 1; j++) {
                if (j < num[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num[i]];
            }
        }
        int half = 0;
        for (int i = sum/2; i >= 0; i--) {
            if (dp[num.length-1][i]) {
                half = i;
                break;
            }
        }
        return Math.abs(2*half-sum);
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}