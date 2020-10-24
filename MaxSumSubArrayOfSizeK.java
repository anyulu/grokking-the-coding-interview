class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        if (arr.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            max = Math.max(max, sum);
            if (end >= k-1) sum -= arr[start++];
        }
        return max;
    }
}