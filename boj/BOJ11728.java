package boj;

public class BOJ11728 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] res = new int[N + M];

        int l = 0;
        int r = 0;
        int cur = 0;
        while (l < N && r < M && cur < N + M) {
            // System.out.println(l + " " + r + " " + cur);
            if (A[l] <= B[r]) {
                res[cur++] = A[l];
                l++;

            } else {
                res[cur++] = B[r];
                r++;
            }
        }

        if (l < N) {
            while (l < N) {
                res[cur++] = A[l++];
            }
        }
        if (r < M) {
            while (r < M) {
                res[cur++] = B[r++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = SC.nextInt();
        }
    }
}
