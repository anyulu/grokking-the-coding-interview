import java.util.*;

class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        if (nodes == 1) return new ArrayList<>(Arrays.asList(0));
        List<Integer> minHeightTrees = new ArrayList<>();
        // TODO: Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (degree[i] == 1) queue.add(i);
        }
        while (!queue.isEmpty()) {
            minHeightTrees = new ArrayList<>();
            int n = queue.size();
            while (n > 0) {
                int root = queue.poll();
                minHeightTrees.add(root);
                n--;
                for (int leaf: map.get(root)) {
                    degree[leaf]--;
                    if (degree[leaf] == 1) queue.add(leaf);
                }
            }
        }
        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
