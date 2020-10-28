class ShortestWindowSort {

    public static int sort(int[] arr) {
        // TODO: Write your code here
        if (arr.length <= 1) return 0;
        int localMax = Integer.MIN_VALUE;
        int localMin = Integer.MAX_VALUE;
        int point1 = 0, point2 = arr.length-1;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (!flag && arr[i] < arr[i-1]) {
                flag = true;
                point1 = i-1;
            }
            if (flag) localMin = Math.min(localMin, arr[i]);
        }
        flag = false;
        for (int i = arr.length-1; i > 0; i--) {
            if (!flag && arr[i] < arr[i-1]) {
                flag = true;
                point2 = i;
            }
            if (flag) localMax = Math.max(localMax, arr[i-1]);
        }
        if (localMax == Integer.MIN_VALUE) return 0;

        int start, end;
        for (start = 0; start <= point1; start++) {
            if (arr[start] > localMin) {
                start--;
                break;
            }
        }
        for (end = arr.length-1; end >= point2; end--) {
            if (arr[end] < localMax) {
                end++;
                break;
            }
        }
        return end-start-1;
    }
}