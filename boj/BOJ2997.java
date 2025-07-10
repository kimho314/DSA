package boj;

import java.util.Arrays;

public class BOJ2997 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(NUMS);

        int n = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            if (n > Math.abs(NUMS[i + 1] - NUMS[i])) {
                n = NUMS[i + 1] - NUMS[i];
            }
        }

        int idx = -1;
        for (int i = 0; i < 2; i++) {
            if (n < Math.abs(NUMS[i + 1] - NUMS[i])) {
                idx = i;
            }
        }

        if (idx == -1) {
            System.out.println(NUMS[2] + n);
        }
        else {
            System.out.println(NUMS[idx] + n);
        }
    }

    private static void input() {
        NUMS = new int[3];
        for (int i = 0; i < 3; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
