class LIS {

    public int findLISLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++)
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));
    }
}