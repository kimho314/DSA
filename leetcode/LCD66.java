package leetcode;

import java.util.*;

public class LCD66 {
    public static void main(String[] args) {
        LCD66 sol = new LCD66();
        System.out.println(Arrays.toString(sol.plusOne(new int[] {1, 2, 3})));
        System.out.println(Arrays.toString(sol.plusOne(new int[] {4, 3, 2, 1})));
        System.out.println(Arrays.toString(sol.plusOne(new int[] {9})));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, set to 0 and continue
            digits[i] = 0;
        }

        // If all digits were 9, we need one extra digit in the beginning
        int[] result = new int[n + 1];
        result[0] = 1; // e.g. [9,9] -> [1,0,0]
        return result;
    }
}
