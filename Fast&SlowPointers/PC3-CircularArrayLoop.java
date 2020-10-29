class CircularArrayLoop {

    public static boolean loopExists(int[] nums) {
        // TODO: Write your code here
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            int fast = next(nums, i);
            int slow = i;
            while (fast != slow && !visit[fast] && !visit[slow]) {
                if (nums[fast] * nums[next(nums, fast)] < 0) break;
                fast = next(nums, next(nums, fast));
                slow = next(nums, slow);
            }
            visit[i] = true;
            if (slow == next(nums, slow)) {
                visit[slow] = true;
                continue;
            } else if (slow == fast) return true;
        }
        return false;
    }

    private static int next(int[]nums, int curr) {
        int res = (curr+nums[curr]) % nums.length;
        return res >= 0 ? res : res+nums.length;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}