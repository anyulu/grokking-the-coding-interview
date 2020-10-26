class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int start = 0;
        int end = arr.length-1;
        while (arr[start] + arr[end] != targetSum) {
            if (arr[start]+arr[end] > targetSum) end--;
            else start++;
        }
        return new int[] { start, end };
    }
}