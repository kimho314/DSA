package boj;

public class BOJ1592 {
    private static FastReader SC = new FastReader();
    private static int N, M, L;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] cnt = new int[N];
        cnt[0] = 1;
        int cur = 0;
        int res = 0;
        while (check(cnt)) {
            res++;
            if (cnt[cur] % 2 == 1) {
                for (int i = 0; i < L; i++) {
                    cur++;
                    if (cur >= N) {
                        cur = 0;
                    }
                }
            }
            else {
                for (int i = 0; i < L; i++) {
                    cur--;
                    if (cur < 0) {
                        cur = N - 1;
                    }
                }
            }
            cnt[cur]++;

        }
        System.out.println(res);
    }

    private static boolean check(int[] cnt) {
        for (int i = 0; i < N; i++) {
            if (cnt[i] >= M) {
                return false;
            }
        }
        return true;
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        L = SC.nextInt();
    }
}
