package boj;

public class BOJ14916 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int limit = N / 5;
        int res = Integer.MAX_VALUE;
        for (int i = limit; i >= 0; i--) {
            int t1 = N - (i * 5);
            int t2 = t1 - (t1 / 2 * 2);
            if (t1 % 2 == 0) {
                res = Math.min(res, i + (t1 / 2));
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
