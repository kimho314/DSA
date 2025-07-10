package boj;

public class BOJ20922 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] cnt = new int[100_001];
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < N) {
            while (r < N && cnt[A[r]] + 1 <= K) {
                cnt[A[r]]++;
                r++;
            }

            int len = r - l;
            res = Math.max(res, len);
            cnt[A[l]]--;
            l++;
        }


        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
