package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ7562 {
    static FastReader sc = new FastReader();
    static int Q;
    static int I;
    static int[] START;
    static int[] END;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIST;
    static int[][] DIR = {{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Q = sc.nextInt();

        while (Q > 0) {
            input();
            bfs(START[0], START[1]);
            sb.append(DIST[END[0]][END[1]]).append('\n');
            Q--;
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
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

                if (dx < 0 || dy < 0 || dx >= I || dy >= I) {
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

    private static void input() {
        I = sc.nextInt();

        MAP = new int[I][I];
        VISITED = new boolean[I][I];
        DIST = new int[I][I];

        START = new int[2];
        START[0] = sc.nextInt();
        START[1] = sc.nextInt();

        END = new int[2];
        END[0] = sc.nextInt();
        END[1] = sc.nextInt();
    }
}
