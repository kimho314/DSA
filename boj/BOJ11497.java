package boj;

import java.util.Arrays;

public class BOJ11497 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();

        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = SC.nextInt();
            }
            Arrays.sort(nums);

            int[] newNums = new int[n];
            int left = 0;
            int right = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    newNums[left++] = nums[i];
                }
                else {
                    newNums[right--] = nums[i];
                }
            }

            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                res = Math.max(res, Math.abs(newNums[i] - newNums[i + 1]));
            }

            SB.append(res).append("\n");
        }
        System.out.println(SB.toString());
    }
}
