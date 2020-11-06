class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        // TODO: Write your code here
        if (arr[0] >= key) return arr[0];
        if (arr[arr.length-1] <= key) return arr[arr.length-1];
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == key) return key;
            else if (arr[mid] < key) start = mid+1;
            else end = mid-1;
        }
        if (arr[start]-key > key-arr[end]) return arr[end];
        return arr[start];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}