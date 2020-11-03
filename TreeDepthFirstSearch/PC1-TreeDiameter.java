class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreeDiameter {
    static int max;
    public static int findDiameter(TreeNode root) {
        // TODO: Write your code here
        max = 0;
        dfs(root, 0);
        return max;
    }

    private static int dfs(TreeNode root, int len) {
        if (root == null) return len;
        int left = dfs(root.left, len);
        int right = dfs(root.right, len);
        if (left + right + 1 > max) max = left+right+1;
        return 1+Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
