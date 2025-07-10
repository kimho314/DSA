package boj;

public class BOJ22862 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
    }

    private static void solve() {
        int r = 0, len = 0, cnt = 0;

        for (int l = 1; l <= N; l++) {
            if (cnt >= 1 && A[l - 1] % 2 != 0) {
                cnt--;
            }

            while (r + 1 <= N && cnt <= K) {
                if (A[++r] % 2 != 0) {
                    cnt++;
                }
            }

            len = Math.max(len, r - l + 1 - cnt);
        }

        System.out.println(len);
    }
}
