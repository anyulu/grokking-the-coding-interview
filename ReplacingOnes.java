class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here
        if (arr.length <= k) return arr.length;
        int start = 0;
        int repeat = 0;
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) curr++;
            repeat = Math.max(curr, repeat);
            while (end-start+1 > k+repeat) {
                if (arr[start] == 1) curr--;
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
