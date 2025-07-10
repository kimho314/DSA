package leetcode;

import java.util.*;

public class LCD26 {
    public static void main(String[] args) {
        LCD26 sol = new LCD26();

        int[] nums = new int[] {1, 1, 2};
        int k = sol.removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, k)));

        nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = sol.removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }

    public int removeDuplicates(int[] nums) {
        int[] res = new int[nums.length];
        int prev = -101;
        int idx = 0;
        for (int elem : nums) {
            if (prev != elem) {
                res[idx] = elem;
                prev = elem;
                idx++;
            }
        }
        // System.out.println(Arrays.toString(res));
        for (int i = 0; i < idx; i++)
            nums[i] = res[i];
        return idx;

    }
}
