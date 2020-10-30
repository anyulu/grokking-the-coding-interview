class CyclicSort {

    public static void sort(int[] nums) {
        // TODO: Write your code here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                nums[nums[i]-1] = nums[i];
                nums[i] = i+1;
            }
        }
        return;
    }
}
