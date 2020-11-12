import java.util.*;

class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
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
        print(tasks, map, requireMap, queue, new ArrayList<Integer>());
        return;
    }

    private static void print(int tasks, Map<Integer, Integer> map, Map<Integer, List<Integer>> requireMap,
                              Queue<Integer> queue, List<Integer> order) {
        if (order.size() == tasks) {
            System.out.println(order);
            return;
        }
        if (queue.isEmpty()) return;
        for (Integer root: queue) {
            order.add(root);
            Queue<Integer> nextQueue = clone(queue);
            nextQueue.remove(root);
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) nextQueue.add(leaf);
            }
            print(tasks, map, requireMap, nextQueue, order);
            order.remove(root);
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)+1);
            }
        }
    }


    private static Queue<Integer> clone(Queue<Integer> queue) {
        Queue<Integer> res = new LinkedList<>();
        for (Integer i: queue) res.add(i);
        return res;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
            new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}