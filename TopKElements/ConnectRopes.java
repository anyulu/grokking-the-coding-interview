import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        // TODO: Write your code here
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) queue.add(ropeLengths[i]);
        int res = 0;
        while (queue.size() >1) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            queue.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
