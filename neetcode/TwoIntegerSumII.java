package neetcode;

import java.util.*;

public class TwoIntegerSumII {
    public static void main(String[] args) {
        TwoIntegerSumII sol = new TwoIntegerSumII();
        System.out.println(Arrays.toString(sol.twoSum(new int[] {1, 3, 5, 6}, 8))); // 2,3
        System.out.println(Arrays.toString(sol.twoSum(new int[] {1, 2, 3, 4}, 3))); // 1,2
        System.out.println(Arrays.toString(sol.twoSum(new int[] {1, 3}, 4))); // 1,2
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0;
        int r = len - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
