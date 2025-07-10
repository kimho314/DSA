package boj;

public class BOJ17608 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] STICKS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int max = 0;
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (max < STICKS[i]) {
                max = STICKS[i];
                res++;
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        STICKS = new int[N];
        for (int i = 0; i < N; i++) {
            STICKS[i] = SC.nextInt();
        }
    }
}
