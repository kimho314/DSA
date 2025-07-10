package boj;

import java.util.*;

public class BOJ16918 {
    private static FastReader SC = new FastReader();
    private static int[][] MAP;
    private static int R, N, C;
    private static boolean[][] VISITED;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int t = 1; t <= N - 1; t++) {
            VISITED = new boolean[R][C];
            if (t % 2 == 1) {
                fill(t);
            } else {
                bomb(t);
            }
            // System.out.println(t);
            // print();
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }

            }
            System.out.println();
        }
    }

    private static void bomb(int curTime) {
        Queue<Integer> q = new LinkedList<>();
        int[][] dist = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (curTime - MAP[i][j] >= 2) {
                    q.add(i);
                    q.add(j);
                    dist[i][j] = 0;
                    VISITED[i][j] = true;
                    MAP[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
                    continue;
                }
                if (VISITED[dy][dx]) {
                    continue;
                }

                dist[dy][dx] = dist[y][x] + 1;
                if (dist[dy][dx] == 1) {
                    MAP[dy][dx] = -1;
                }
                VISITED[dy][dx] = true;

                q.add(dy);
                q.add(dx);
            }
        }
    }



    private static void fill(int curTime) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] == -1) {
                    MAP[i][j] = curTime;
                }
            }
        }
    }



    private static void input() {
        R = SC.nextInt();
        C = SC.nextInt();
        N = SC.nextInt();
        MAP = new int[R][C];
        VISITED = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String col = SC.nextLine();
            for (int j = 0; j < col.length(); j++) {
                if (col.charAt(j) == '.') {
                    MAP[i][j] = -1;
                } else {
                    MAP[i][j] = 0;
                }
            }
        }
    }
}
