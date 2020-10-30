import java.util.*;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        // TODO: Write your code here
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) missingNumbers.add(i+1);
        }
        return missingNumbers;
    }
}
