import java.util.*;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        // TODO: Write your code here
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((i,j) -> capital[i]-capital[j]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((i,j) -> profits[j]-profits[i]);
        int curr = initialCapital;
        for (int i = 0; i < profits.length; ++i) {
            minCapital.add(i);
        }
        for (int i = 0; i < numberOfProjects; ++i) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= curr) {
                maxProfit.add(minCapital.poll());
            }
            if (maxProfit.isEmpty()) break;
            curr += profits[maxProfit.poll()];
        }
        return curr;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}