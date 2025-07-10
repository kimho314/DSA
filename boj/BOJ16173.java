package boj;

public class BOJ16173 {
    static FastReader SC = new FastReader();
    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIR = {{0, 1}, {1, 0}};
    static boolean IS_REACHED_TO_END = false;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(0, 0);

        if (IS_REACHED_TO_END) {
            System.out.println("HaruHaru");
        }
        else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        if (MAP[y][x] == -1) {
            IS_REACHED_TO_END = true;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int dy = y + (DIR[i][0] == 1 ? MAP[y][x] : DIR[i][0]);
            int dx = x + (DIR[i][1] == 1 ? MAP[y][x] : DIR[i][1]);

            if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                continue;
            }
            if (VISITED[dy][dx]) {
                continue;
            }

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
    }
}
