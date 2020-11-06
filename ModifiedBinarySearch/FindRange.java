class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        // TODO: Write your code here
        if (arr.length == 0 || arr[0] > key || arr[arr.length-1] < key) return result;
        int start = 0, end = arr.length-1;
        while (start <= end) {
            result[0] = start + (end-start)/2;
            if (arr[result[0]] == key && (result[0] == 0 || arr[result[0]-1] != key)) break;
            if (arr[result[0]] >= key) end = result[0]-1;
            else start = result[0]+1;
        }
        start = 0;
        end = arr.length-1;
        while (start <= end) {
            result[1] = start + (end-start)/2;
            if (arr[result[1]] == key && (result[1] == arr.length-1 || arr[result[1]+1] != key)) break;
            if (arr[result[0]] <= key) start = result[1]+1;
            else end = result[1]-1;
        }
        if (arr[result[0]] != key) return new int[]{-1,-1};
        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}