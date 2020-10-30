import java.util.*;

class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        // TODO: Write your code here
        int i = 0;
        int[] newNums = new int[nums.length+k];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        while (i < newNums.length) {
            if (newNums[i] > 0 && newNums[i] < newNums.length && newNums[i] != newNums[newNums[i]-1]) {
                int temp = newNums[newNums[i]-1];
                newNums[newNums[i]-1] = newNums[i];
                newNums[i] = temp;
            } else i++;
        }

        for (i = 0; i < newNums.length; i++) {
            if (k > 0 && newNums[i] != i+1) {
                k--;
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
}