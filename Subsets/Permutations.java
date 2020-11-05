// dfs
import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}

// bfs
import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = queue.size();
            while (size > 0) {
                size--;
                List<Integer> temp = queue.poll();
                int n = temp.size();
                for (int i = 0; i <= n; i++) {
                    List<Integer> newTemp = new ArrayList<>(temp);
                    newTemp.add(i, num);
                    if (newTemp.size() == nums.length) result.add(newTemp);
                    else queue.add(newTemp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
