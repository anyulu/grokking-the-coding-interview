import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    static int sum;
    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here
        if (root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
