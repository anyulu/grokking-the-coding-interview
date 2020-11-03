
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreePathSum {
    static boolean exist = false;
    public static boolean hasPath(TreeNode root, int sum) {
        // TODO: Write your code here
        exist = false;
        dfs(root, sum, 0);
        return exist;
    }

    private static void dfs(TreeNode root, int sum, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == sum) exist = true;
            return;
        }
        if (root.left != null) dfs(root.left, sum, currSum);
        if (root.right != null) dfs(root.right, sum, currSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
