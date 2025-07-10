package boj;

public class BOJ3187 {
    static FastReader SC = new FastReader();
    static int R, C;
    static char[][] MAP;
    static boolean[][] VISITED;
    static int V, K;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        R = SC.nextInt();
        C = SC.nextInt();
        MAP = new char[R][C];
        VISITED = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < C; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }

        int resK = 0;
        int resV = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] != '.' && !VISITED[i][j]) {
                    V = 0;
                    K = 0;

                    dfs(i, j);

                    if (K > V) {
                        V = 0;
                    }
                    else {
                        K = 0;
                    }
                    resK += K;
                    resV += V;
                }
            }
        }

        System.out.println(resK + " " + resV);
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
                continue;
            }
            if (VISITED[dy][dx] || MAP[dy][dx] == '#') {
                continue;
            }

            if (MAP[dy][dx] == 'k') {
                K++;
            }
            if (MAP[dy][dx] == 'v') {
                V++;
            }

            dfs(dy, dx);
        }
    }
}
