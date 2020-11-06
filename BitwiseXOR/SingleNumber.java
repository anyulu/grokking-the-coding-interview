class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        // TODO: Write your code here
        int res = 0;
        for (int i = 0; i < arr.length; i++) res ^= arr[i];
        return res;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}