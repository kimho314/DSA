package leetcode;

import java.util.Arrays;

public class LCD88 {
    public static void main(String[] args) {
        LCD88 sol = new LCD88();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        sol.merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {1};
        nums2 = new int[] {};
        sol.merge1(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {0};
        nums2 = new int[] {1};
        sol.merge1(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;


        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }


        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
