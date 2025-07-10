package boj;

public class BOJ1189 {
    static FastReader SC = new FastReader();
    static int R, C, K, CNT = 0;
    static char[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        R = SC.nextInt();
        C = SC.nextInt();
        K = SC.nextInt();
        MAP = new char[R][C];
        VISITED = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = SC.nextLine();
            for (int j = 0; j < C; j++) {
                MAP[i][j] = s.charAt(j);
            }
        }

        dfs(R - 1, 0, 1);
        System.out.println(CNT);
    }

    private static void dfs(int y, int x, int dist) {
        if (y == 0 && x == C - 1) {
            if (dist == K) {
                CNT++;
            }
        }
        else {
            VISITED[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
                    continue;
                }
                if (MAP[dy][dx] == 'T' || VISITED[dy][dx]) {
                    continue;
                }

                ++dist;
                dfs(dy, dx, dist);
                --dist;
                VISITED[dy][dx] = false;
            }
        }
    }
}
