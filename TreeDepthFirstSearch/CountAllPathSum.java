import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        return dfs(root, S, 0, false);
    }

    private static int dfs(TreeNode root, int S, int count, boolean next) {
        if (root == null) return count;
        if (root.val == S) count++;
        if (root.left == null && root.right == null) return count;
        if (next) {
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        } else {
            count = dfs(root.left, S, count, false);
            count = dfs(root.right, S, count, false);
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
