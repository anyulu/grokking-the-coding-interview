import java.util.*;

class TaskSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tasks; i++) {
            map.put(i, 0);
            requireMap.put(i, new ArrayList<Integer>());
        }
        for (int[] line: prerequisites) {
            map.put(line[1], map.get(line[1])+1);
            requireMap.get(line[0]).add(line[1]);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        while (!queue.isEmpty()) {
            int root = queue.poll();
            sortedOrder.add(root);
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        if (sortedOrder.size() != tasks) return new ArrayList<>();
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
            new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}