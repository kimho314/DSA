package boj;

import java.util.ArrayDeque;

public class BOJ28323 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        boolean isPrevOdd = false;
        for (int i = 0; i < N; i++) {
            int num = A[i];
            boolean isOdd = num % 2 != 0;
            if (dq.isEmpty() || isOdd != isPrevOdd) {
                dq.addFirst(num);
            }
            isPrevOdd = num % 2 != 0;
        }

        System.out.println(dq.size());
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
