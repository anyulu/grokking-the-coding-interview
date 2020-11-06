class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
        // TODO: Write your code here
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (arr[mid] < arr[0]) end = mid-1;
            else start = mid+1;
        }
        return (end+1) % arr.length;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
