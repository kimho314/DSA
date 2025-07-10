package boj;

public class BOJ2846 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] PI;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;

        int start = PI[0];
        for (int i = 1; i < N; i++) {
            if (i < N - 1 && PI[i] <= PI[i - 1] && PI[i] < PI[i + 1]) {
                start = PI[i];
            }
            if (PI[i] > PI[i - 1] && (i == N - 1 || PI[i] >= PI[i + 1])) {
                res = Math.max(res, PI[i] - start);
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        PI = new int[N];
        for (int i = 0; i < N; i++) {
            PI[i] = SC.nextInt();
        }
    }
}
