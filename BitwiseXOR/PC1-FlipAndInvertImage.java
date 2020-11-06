class Solution {
    public static int[][] flipAndInvertImage(int[][] arr) {
        //TODO: Write your code here
        int len = arr.length;
        int size = arr[0].length;
        int[][] result = new int[len][size];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++){
                result[i][j] = 1^arr[i][size-1-j];
            }
        }

        return result;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}