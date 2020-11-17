class Knapsack {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        //TODO: Write - Your - Code
        int[] dp = new int[capacity+1];
        for (int i = 0; i < capacity+1; i++) {
            if (weights[0] <= i) dp[i] = profits[0];
        }
        for (int j = 1; j < profits.length; j++) {
            for (int i = capacity; i >= 0; i--) {
                if (i >= weights[j]) dp[i] = Math.max(dp[i], dp[i-weights[j]]+profits[j]);
            }
        }
        return dp[capacity];
    }
}