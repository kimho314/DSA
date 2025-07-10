package boj;

public class BOJ4158 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] A, B;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            N = SC.nextInt();
            M = SC.nextInt();
            if (N == 0 && M == 0) {
                break;
            }

            A = new int[N];
            B = new int[M];
            for (int i = 0; i < N; i++) {
                A[i] = SC.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = SC.nextInt();
            }

            solve();
        }

        System.out.println(SB.toString());
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = M - 1;
            int res = -1;
            while (l <= r) {
                int mid = (r + l) / 2;
                if (A[i] == B[mid]) {
                    res = mid;
                    break;
                }
                else if (A[i] > B[mid]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }

            if (res != -1) {
                cnt++;
            }
        }
        SB.append(cnt).append('\n');
    }
}
