class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        if (arr.length == 0) return -1;
        int start = 0, end = arr.length-1;
        while (start < end) {
            int mid = start+(end-start)/2;
            if (arr[mid] > arr[mid+1]) end = mid;
            else start = mid+1;
        }
        int peak = start;
        start = 0;
        end = arr.length-1;
        if (arr[0] <= key && key <= arr[peak]) {
            while (start <= end) {
                int mid = start+(end-start)/2;
                if (arr[mid] == key) return mid;
                if (arr[mid] < key) start = mid+1;
                else end = mid-1;
            }
        }
        if (arr[peak] >= key && key >= arr[arr.length-1]) {
            start = 0;
            end = arr.length-1;
            while (start <= end) {
                int mid = start+(end-start)/2;
                if (arr[mid] == key) return mid;
                if (arr[mid] > key) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}