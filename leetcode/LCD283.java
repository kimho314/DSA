package leetcode;

import java.util.*;

public class LCD283 {
    public static void main(String[] args) {
        LCD283 sol = new LCD283();
        int[] nums = new int[] {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0};
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
