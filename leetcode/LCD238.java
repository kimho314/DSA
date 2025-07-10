package leetcode;

import java.util.*;

public class LCD238 {
    public static void main(String[] args) {
        LCD238 sol = new LCD238();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] arr) {
        int[] suffix = new int[arr.length];
        int[] prefix = new int[arr.length];
        int[] res = new int[arr.length];

        prefix[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        suffix[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
