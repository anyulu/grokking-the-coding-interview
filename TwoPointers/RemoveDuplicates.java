class RemoveDuplicates {

    public static int remove(int[] arr) {
        // TODO: Write your code here
        if (arr.length == 0) return 0;
        int write = 1;
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp) {
                temp = arr[i];
                arr[write++] = temp;
            }
        }
        return write;
    }
}
