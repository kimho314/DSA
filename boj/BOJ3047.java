package boj;

import java.util.Arrays;

public class BOJ3047 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;
    private static char[] CHARS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(NUMS);

        StringBuilder sb = new StringBuilder();
        for (char ch : CHARS) {
            if (ch == 'A') {
                sb.append(NUMS[0]).append(" ");
            }
            if (ch == 'B') {
                sb.append(NUMS[1]).append(" ");
            }
            if (ch == 'C') {
                sb.append(NUMS[2]).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static void input() {
        NUMS = new int[3];
        for (int i = 0; i < 3; i++) {
            NUMS[i] = SC.nextInt();
        }
        CHARS = SC.next().toCharArray();
    }
}
