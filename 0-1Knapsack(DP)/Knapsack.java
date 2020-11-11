class Knapsack {
  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    // TODO: Write your code here
    return dp(profits, weights, capacity, 0, 0);
  }

  private int dp(int[] profits, int[] weights, int capacity, int index, int res) {
    if (index == profits.length) return res;
    if (weights[index] > capacity) return dp(profits, weights, capacity, index+1, res);
    return Math.max(dp(profits, weights, capacity, index+1, res), dp(profits, weights, capacity-weights[index], index+1, res+profits[index]));
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}