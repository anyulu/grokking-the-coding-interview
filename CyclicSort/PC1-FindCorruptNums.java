class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
        // TODO: Write your code here
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return new int[] { -1, -1 };
    }
}
