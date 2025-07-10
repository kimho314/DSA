package boj;

public class BOJ2875 {
    private static FastReader SC = new FastReader();
    private static int N, M, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        while (N >= 2 && M >= 1 && (N + M) - K >= 3) {
            res++;
            N -= 2;
            M--;
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
    }
}
