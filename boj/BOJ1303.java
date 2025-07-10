package boj;

public class BOJ1303 {
    static FastReader SC = new FastReader();
    static int N, M;
    static String[][] MAP;
    static boolean[][] VISITED;
    static int CNT;
    static int[] GROUP = new int[2];
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new String[M][N];
        VISITED = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] inputs = SC.nextLine().split("");
            for (int j = 0; j < N; j++) {
                MAP[i][j] = inputs[j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j]) {
                    CNT = 0;
                    dfs(i, j, MAP[i][j]);
//                    System.out.println(i + "," + j + " " + MAP[i][j] + " " + CNT);
                    int power = (CNT * CNT);
                    if (MAP[i][j].equals("W")) {
                        GROUP[0] += power;
                    }
                    else {
                        GROUP[1] += power;
                    }
                }
            }
        }

        System.out.println(GROUP[0] + " " + GROUP[1]);
    }

    private static void dfs(int y, int x, String color) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= M || dx >= N) {
                continue;
            }
            if (VISITED[dy][dx] || !MAP[dy][dx].equals(color)) {
                continue;
            }

            dfs(dy, dx, color);
        }
    }
}
