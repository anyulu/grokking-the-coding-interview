import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) return allPaths;
        dfs(root, sum, new ArrayList<Integer>(), 0, allPaths);
        return allPaths;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> list, int currSum, List<List<Integer>> res) {
        if (root == null) return;
        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) res.add(new ArrayList<Integer>(list));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            dfs(root.right, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
