package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ13565 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = SC.next().toCharArray();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        bfs();

        String answer = "NO";
        for (int i = 0; i < M; i++) {
            if (VISITED[N - 1][i]) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (MAP[0][i] == 0) {
                q.add(0);
                q.add(i);
                VISITED[0][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                    continue;
                }
                if (MAP[dy][dx] == 1 || VISITED[dy][dx]) {
                    continue;
                }

                q.add(dy);
                q.add(dx);
                VISITED[dy][dx] = true;
            }
        }

    }
}
