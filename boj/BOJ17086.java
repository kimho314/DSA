package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ17086 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIST;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static class Pos {
        public int x;
        public int y;

        public Pos(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        List<Pos> sharks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 1) {
                    sharks.add(new Pos(j, i));
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 0) {
                    VISITED = new boolean[N][M];
                    DIST = new int[N][M];

                    bfs(i, j);

                    int min = Integer.MAX_VALUE;
                    for (Pos pos : sharks) {
                        int dist = DIST[pos.y][pos.x];
                        min = Math.min(min, dist);
                    }
                    res = Math.max(res, min);
                }
            }
        }
        System.out.println(res);
    }

    private static void bfs(int startY, int startX) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        VISITED[startY][startX] = true;
        DIST[startY][startX] = 0;

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < DIR.length; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                    continue;
                }
                if (VISITED[dy][dx]) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                VISITED[dy][dx] = true;
                DIST[dy][dx] = DIST[y][x] + 1;
            }
        }
    }
}
