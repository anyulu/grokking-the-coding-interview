import java.util.*;

class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        // TODO: Write your code here
        if (originalSeq.length == 0 || sequences.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < originalSeq.length; i++) {
            map.put(originalSeq[i], 0);
            requireMap.put(originalSeq[i], new ArrayList<Integer>());
        }
        for (int[] sequence: sequences) {
            for (int i = 0; i < sequence.length; i++) {
                if (!map.containsKey(sequence[i])) return false;
                if (i == sequence.length-1) break;
                if (!map.containsKey(sequence[i+1])) return false;
                map.put(sequence[i+1], map.get(sequence[i+1])+1);
                requireMap.get(sequence[i]).add(sequence[i+1]);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int root = queue.poll();
            if (originalSeq[index++] != root || !queue.isEmpty()) return false;
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        return originalSeq.length == index;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
            new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}