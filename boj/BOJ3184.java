package boj;

public class BOJ3184 {
    static FastReader SC = new FastReader();
    static int R, C;
    static char[][] MAP;
    static boolean[][] VISITED;
    static int NUM_OF_SHEEPS;
    static int NUM_OF_WOLVES;
    static int TOTAL_NUM_OF_SHEEPS;
    static int TOTAL_NUM_OF_WOLVES;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        R = SC.nextInt();
        C = SC.nextInt();
        MAP = new char[R][C];
        VISITED = new boolean[R][C];
        TOTAL_NUM_OF_SHEEPS = 0;
        TOTAL_NUM_OF_WOLVES = 0;
        for (int i = 0; i < R; i++) {
            String line = SC.nextLine();
            for (int j = 0; j < C; j++) {
                MAP[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                NUM_OF_SHEEPS = 0;
                NUM_OF_WOLVES = 0;

                if (MAP[i][j] != '#' && !VISITED[i][j]) {
                    dfs(i, j);
                }

                if (NUM_OF_WOLVES == 0 && NUM_OF_SHEEPS == 0) {
                    continue;
                }
                if (NUM_OF_SHEEPS > NUM_OF_WOLVES) {
                    TOTAL_NUM_OF_SHEEPS += NUM_OF_SHEEPS;
                }
                else {
                    TOTAL_NUM_OF_WOLVES += NUM_OF_WOLVES;
                }
            }
        }


        System.out.println(TOTAL_NUM_OF_SHEEPS + " " + TOTAL_NUM_OF_WOLVES);
    }

    private static void dfs(int x, int y) {
        VISITED[x][y] = true;
        if (MAP[x][y] == 'v') {
            NUM_OF_WOLVES++;
        }
        if (MAP[x][y] == 'o') {
            NUM_OF_SHEEPS++;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + DIR[i][0];
            int dy = y + DIR[i][1];

            if (dx < 0 || dy < 0 || dx >= R || dy >= C) {
                continue;
            }
            if (VISITED[dx][dy]) {
                continue;
            }
            if (MAP[dx][dy] == '#') {
                continue;
            }

            dfs(dx, dy);
        }
    }
}
