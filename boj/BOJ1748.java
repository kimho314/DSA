package boj;

import java.util.*;

public class BOJ1748 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int len = String.valueOf(N).length();
        int start = 1;
        int end = 0;
        long res = 0;

        for (int i = 1; i < len; i++) {
            start = (int) Math.pow(10, i - 1);
            end = start * 10 - 1;
            res += (long) (end - start + 1) * i;
        }

        start = (int) Math.pow(10, len - 1);
        end = Math.min(N, start * 10 - 1);
        res += (long) (end - start + 1) * len;

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
