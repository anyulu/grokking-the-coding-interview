class FirstMissingPositive {

    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        for (int i = 0; i < nums.length+1; i++) {
            queue.add(i+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) queue.remove(nums[i]);
        }
        return queue.peek();
    }
}
