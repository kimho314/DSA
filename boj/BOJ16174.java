package boj;

public class BOJ16174 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static boolean isEnd;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(0, 0);

        if (isEnd) {
            System.out.println("HaruHaru");
        }
        else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        if (MAP[y][x] == -1) {
            isEnd = true;
            return;
        }

        int dy = y + MAP[y][x];
        int dx = x;
        if (dy >= 0 && dy < N && dx >= 0 && dx < N && !VISITED[dy][dx]) {
            dfs(dy, dx);
        }

        dx = x + MAP[y][x];
        dy = y;
        if (dy >= 0 && dy < N && dx >= 0 && dx < N && !VISITED[dy][dx]) {
            dfs(dy, dx);
        }
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new int[N][N];
        VISITED = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
        isEnd = false;
    }
}
