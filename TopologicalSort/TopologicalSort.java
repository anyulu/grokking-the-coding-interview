import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap();
        for (int i = 0; i < vertices; i++) {
            map.put(i, 0);
            edgeMap.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            map.put(edge[1], map.get(edge[1])+1);
            edgeMap.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        while (!queue.isEmpty()) {
            int root = queue.poll();
            sortedOrder.add(root);
            for (int leaf: edgeMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
            new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
            new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}