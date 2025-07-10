package boj;

import java.util.Arrays;

public class BOJ13866 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(NUMS);

        int sum1 = NUMS[0] + NUMS[3];
        int sum2 = NUMS[1] + NUMS[2];

        System.out.println(Math.abs(sum1 - sum2));
    }

    private static void input() {
        NUMS = new int[4];
        for (int i = 0; i < 4; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
