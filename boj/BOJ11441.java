package boj;

public class BOJ11441 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < M; cnt++) {
            int i = SC.nextInt();
            int j = SC.nextInt();

            int res = sum[j] - sum[i - 1];
            sb.append(res).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
        M = SC.nextInt();
    }
}
