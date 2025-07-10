package boj;

import java.util.Arrays;

public class BOJ14247 {
    static FastReader SC = new FastReader();
    static int N;
    static Wood[] WOODS;
    static int[] H;
    static int[] A;

    static class Wood implements Comparable<Wood> {
        int h;
        int a;

        @Override
        public int compareTo(Wood o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(WOODS);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ((long) WOODS[i].a * (long) i + (long) WOODS[i].h);
        }
        System.out.println(sum);
    }

    private static void input() {
        N = SC.nextInt();
        WOODS = new Wood[N];
        H = new int[N];
        A = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = SC.nextInt();
        }
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        for (int i = 0; i < N; i++) {
            Wood w = new Wood();
            w.h = H[i];
            w.a = A[i];
            WOODS[i] = w;
        }
    }
}
