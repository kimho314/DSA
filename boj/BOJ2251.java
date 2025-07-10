package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ2251 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int[] LIMIT;
    static boolean[] POSSIBLE;
    static boolean[][][] VISITED;

    static class State {
        int[] x;

        State(int[] _x) {
            x = new int[3];
            System.arraycopy(_x, 0, x, 0, 3);
        }

        State move(int from, int to, int[] limit) {
            int[] nX = new int[]{x[0], x[1], x[2]};
            if (x[from] + x[to] <= limit[to]) {
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }
            else {
                nX[from] -= limit[to] - nX[to];
                nX[to] = limit[to];
            }
            return new State(nX);
        }
    }

    public static void main(String[] args) {
        LIMIT = new int[3];
        for (int i = 0; i < 3; i++) {
            LIMIT[i] = SC.nextInt();
        }
        VISITED = new boolean[201][201][201];
        POSSIBLE = new boolean[201];

        bfs(0, 0, LIMIT[2]);
        for (int i = 0; i <= 200; i++) {
            if (POSSIBLE[i]) {
                SB.append(i).append(' ');
            }
        }
        System.out.println(SB);
    }

    private static void bfs(int x1, int x2, int x3) {
        Queue<State> needVisit = new LinkedList<>();
        VISITED[x1][x2][x3] = true;
        needVisit.add(new State(new int[]{x1, x2, x3}));

        while (!needVisit.isEmpty()) {
            State st = needVisit.poll();
            if (st.x[0] == 0) {
                POSSIBLE[st.x[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }

                    State next = st.move(from, to, LIMIT);

                    if (!VISITED[next.x[0]][next.x[1]][next.x[2]]) {
                        VISITED[next.x[0]][next.x[1]][next.x[2]] = true;
                        needVisit.add(next);
                    }
                }
            }
        }
    }
}
