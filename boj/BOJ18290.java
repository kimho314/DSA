package boj;

public class BOJ18290 {
    private static FastReader SC = new FastReader();
    private static int N, M, K;
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static int MAX;
    private static int[][] DIR = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(0, 0, 0, 0);
        System.out.println(MAX);
    }

    private static void dfs(int y, int x, int cnt, int sum) {
        if (cnt == K) {
            MAX = Math.max(MAX, sum);
        }
        else {
            for (int i = y; i < N; i++) {
                for (int j = x; j < M; j++) {
                    if (VISITED[i][j]) {
                        continue;
                    }

                    boolean isValid = true;
                    for (int k = 0; k < DIR.length; k++) {
                        int dy = i + DIR[k][0];
                        int dx = j + DIR[k][1];
                        if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                            continue;
                        }
                        if (VISITED[dy][dx]) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        VISITED[i][j] = true;
                        dfs(y, x, cnt + 1, sum + MAP[i][j]);
                        VISITED[i][j] = false;
                    }
                }
            }
        }
    }


    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
        VISITED = new boolean[N][M];
        MAX = Integer.MIN_VALUE;
    }
}
