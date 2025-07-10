package boj;

public class BOJ14248 {
    static FastReader SC = new FastReader();
    static int N, S;
    static int[] A;
    static boolean[] VISITED;
    static int[] DIR = {1, -1};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(S - 1);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (VISITED[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int n) {
        VISITED[n] = true;
        for (int i = 0; i < 2; i++) {
            int dx = n + (DIR[i] * A[n]);
            if (dx < 0 || dx >= N) {
                continue;
            }
            if (VISITED[dx]) {
                continue;
            }

            dfs(dx);
        }
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        S = SC.nextInt();
        VISITED = new boolean[N];
    }
}
