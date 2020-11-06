class SearchRotatedArray {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == key ? 0 : -1;
        int start = 0, end = arr.length-1, mid = 0;
        while (start <= end) {
            mid = start+(end-start)/2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) {
                if (arr[mid] < arr[0] && key >= arr[0]) end = mid-1;
                else start = mid+1;
            } else {
                if (arr[mid] >= arr[0] && key < arr[0]) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
