package boj;

public class BOJ21736 {
    static FastReader SC = new FastReader();
    static int N, M;
    static String[][] MAP;
    static boolean[][] VISITED;
    static int CNT = 0;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new String[N][M];
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = SC.next().toCharArray();
            for (int j = 0; j < line.length; j++) {
                MAP[i][j] = String.valueOf(line[j]);
            }
        }

        int iy = 0;
        int ix = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j].equals("I")) {
                    iy = i;
                    ix = j;
                }
            }
        }
        VISITED[iy][ix] = true;

        dfs(iy, ix);
        System.out.println(CNT == 0 ? "TT" : CNT);
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        if (MAP[y][x].equals("P")) {
            CNT++;
        }

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                continue;
            }
            if (MAP[dy][dx].equals("X") || VISITED[dy][dx]) {
                continue;
            }

            dfs(dy, dx);
        }
    }
}
