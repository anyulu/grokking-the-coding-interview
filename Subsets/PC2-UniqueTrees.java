import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        // TODO: Write your code here
        return generate(1,n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = new ArrayList<>(generate(start, i-1));
            List<TreeNode> right = new ArrayList<>(generate(i+1, end));
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
