package leetcode;

import java.util.*;

public class LCD27 {
    public static void main(String[] args) {
        LCD27 sol = new LCD27();
        int res = sol.removeElement(new int[] {3, 2, 2, 3}, 3);
        IO.println(res);
        res = sol.removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2);
        IO.println(res);
        res = sol.removeElement(new int[] {}, 0);
        IO.println(res);
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
