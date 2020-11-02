import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        // TODO: Write your code here
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reach = false;
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (reach) return node;
                if (node.val == key) reach = true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
