package boj;

public class BOJ1806 {
    private static FastReader SC = new FastReader();
    private static int N, S;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int r = 0;
        int sum = 0;
        int ans = N + 1;
        for (int l = 1; l <= N; l++) {
            sum -= A[l - 1];
            while (r + 1 <= N && sum < S) {
                sum += A[++r];
            }
            if (sum >= S) {
                ans = Math.min(ans, r - l + 1);
            }
        }

        if (ans == N + 1) {
            ans = 0;
        }
        System.out.println(ans);
    }

    private static void input() {
        N = SC.nextInt();
        S = SC.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
    }

}
