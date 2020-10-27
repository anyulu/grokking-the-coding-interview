class DutchFlag {

    public static void sort(int[] arr) {
        // TODO: Write your code here
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < arr.length-1-i) {
                if (arr[j] > arr[j+1]) swap(arr,j,j+1);
                j++;
            }
        }
        return;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
