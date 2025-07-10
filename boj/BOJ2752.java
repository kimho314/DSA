package boj;

import java.util.Arrays;

public class BOJ2752 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(NUMS);

        for (int n : NUMS) {
            System.out.print(n + " ");
        }
    }

    private static void input() {
        NUMS = new int[3];
        for (int i = 0; i < 3; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
