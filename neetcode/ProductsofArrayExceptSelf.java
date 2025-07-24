package neetcode;

import java.util.*;
import java.io.*;
import java.math.*;

public class ProductsofArrayExceptSelf {
    public static void main(String[] args) {
        ProductsofArrayExceptSelf sol = new ProductsofArrayExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {1, 2, 4, 6})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {-1, 0, 1, 2, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int product = 1;
        for (int i = 0; i < len; i++) {
            product *= nums[i];
            prefix[i] = product;
        }
        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            product *= nums[i];
            suffix[i] = product;
        }

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[i] = suffix[i + 1];
            } else if (i == len - 1) {
                res[i] = prefix[i - 1];
            } else {
                res[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return res;
    }
}
