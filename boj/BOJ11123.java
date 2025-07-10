package boj;

public class BOJ11123 {
    static FastReader SC = new FastReader();
    static int T, H, W;
    static char[][] MAP;
    static boolean[][] VISITED;
    static int CNT = 0;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static StringBuilder SB = new StringBuilder();


    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            H = SC.nextInt();
            W = SC.nextInt();
            MAP = new char[H][W];
            VISITED = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                String input = SC.nextLine();
                for (int j = 0; j < W; j++) {
                    MAP[i][j] = input.charAt(j);
                }
            }

            CNT = 0;
            solve();
            SB.append(CNT).append('\n');
        }
        System.out.println(SB.toString());
    }

    private static void solve() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (MAP[i][j] == '#' && !VISITED[i][j]) {
                    dfs(i, j);
                    CNT++;
                }
            }
        }
    }


    private static void dfs(int y, int x) {
        VISITED[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= H || dx >= W) {
                continue;
            }
            if (VISITED[dy][dx] || MAP[dy][dx] != '#') {
                continue;
            }

            dfs(dy, dx);
        }
    }
}
