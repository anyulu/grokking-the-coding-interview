class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int start = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= S) {
                res = Math.min(res, end-start+1);
                sum -= arr[start];
                start++;
            }
        }
        return res;
    }
}
