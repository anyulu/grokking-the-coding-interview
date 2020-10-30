import java.util.*;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        // TODO: Write your code here
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1) {
                if (nums[i] == nums[nums[i]-1]) {
                    i++;
                    continue;
                }
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) duplicateNumbers.add(nums[i]);
        }
        return duplicateNumbers;
    }
}
