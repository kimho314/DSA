package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BOJ3460 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = NUMS[i];
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            while (n >= 1) {
                int res = n % 2;
                dq.addLast(res);
                n /= 2;
            }

            ArrayList<Integer> list = new ArrayList<>(dq);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 1) {
                    sb.append(j).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
        NUMS = new int[T];
        for (int i = 0; i < T; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
