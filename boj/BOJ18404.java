package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ18404 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] ENEMIES;
    static int[] NIGHT = new int[2]; // 0 - x. 1 - y
    static boolean[][] VISITED;
    static int[][] DIST;
    static int[][] DIR = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        ENEMIES = new int[M][2];
        VISITED = new boolean[N][N];
        DIST = new int[N][N];
        NIGHT[0] = sc.nextInt();
        NIGHT[1] = sc.nextInt();
        for (int i = 0; i < M; i++) {
            ENEMIES[i][0] = sc.nextInt();
            ENEMIES[i][1] = sc.nextInt();
        }

        bfs(NIGHT[0] - 1, NIGHT[1] - 1);

        for (int[] enemy : ENEMIES) {
            sb.append(DIST[enemy[0] - 1][enemy[1] - 1]).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(x);
        needVisit.add(y);
        VISITED[x][y] = true;
        DIST[x][y] = 0;

        while (!needVisit.isEmpty()) {
            x = needVisit.poll();
            y = needVisit.poll();

            for (int i = 0; i < DIR.length; i++) {
                int dx = x + DIR[i][0];
                int dy = y + DIR[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                    continue;
                }
                if (VISITED[dx][dy]) {
                    continue;
                }

                needVisit.add(dx);
                needVisit.add(dy);
                VISITED[dx][dy] = true;
                DIST[dx][dy] = DIST[x][y] + 1;
            }
        }
    }
}
