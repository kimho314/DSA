package boj;

import java.util.ArrayDeque;

public class BOJ11576 {
    private static FastReader SC = new FastReader();
    private static int A, B;
    private static int M;
    private static ArrayDeque<Integer> STACK = new ArrayDeque<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long sum = 0;
        for (int i = 0; i < M; i++) {
            int num = STACK.pop();
            sum += (long) num * (long) Math.pow(A, i);
        }

        ArrayDeque<Long> res = new ArrayDeque<>();
        while (sum / B > 0) {
            res.push(sum % B);
            sum /= B;
        }
        res.push(sum);

        while (!res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        M = SC.nextInt();
        for (int i = 0; i < M; i++) {
            STACK.push(SC.nextInt());
        }
    }
}
