package boj;

public class BOJ22864 {
    private static FastReader SC = new FastReader();
    private static int A, B, C, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int p = 0;
        int res = 0;
        for (int i = 1; i <= 24; i++) {
            if (p + A > M) {
                p -= C;
                if (p < 0) {
                    p = 0;
                }
                continue;
            }

            p += A;
            res += B;
        }
        System.out.println(res);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
        M = SC.nextInt();
    }
}
