import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class CountUniqueTrees {
    public int countTrees(int n) {
        // TODO: Write your code here
        if (n <= 0) return 0;
        return count(1,n);
    }

    private int count(int start, int end) {
        if (start > end) return 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i-1);
            int right = count(i+1, end);
            sum += left*right;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}

//simplify
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n <= 0) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i-1) * numTrees(n-i);
        }
        map.put(n, sum);
        return sum;
    }
}