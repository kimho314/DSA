package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ14502 {
    static FastReader SC = new FastReader();
    static int N, M, B, ANS;
    static int[][] A, BLANK;
    static boolean[][] VISITED;
    static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N + 1][M + 1];
        BLANK = new int[N * M + 1][2];
        VISITED = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                A[i][j] = SC.nextInt();
            }
        }

        // 벽을 놓을 수 있는 위치 모아놓기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) {
                    B++;
                    BLANK[B][0] = i;
                    BLANK[B][1] = j;
                }
            }
        }

        dfs(1, 0);
        System.out.println(ANS);
    }

    // idx 번째 빈 칸텡 벽을 세울 지 말지 결정 하고, cnt 개의 벽을 세운다
    private static void dfs(int idx, int count) {
        if (count == 3) {
            bfs();
            return;
        }
        if (idx > B) { // 더 이상 세울 수 있는 벽이 없을 경우
            return;
        }

        A[BLANK[idx][0]][BLANK[idx][1]] = 1;
        dfs(idx + 1, count + 1); // idx 번째에 벽을 세 웠을 경우의 수 구하기

        A[BLANK[idx][0]][BLANK[idx][1]] = 0;
        dfs(idx + 1, count); // idx 번째에 벽을 안 새웠을 경우의 수 구하기
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                VISITED[i][j] = false;
                if (A[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    VISITED[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int dx = x + DIR[k][0];
                int dy = y + DIR[k][1];

                if (dx < 1 || dy < 1 || dx > N || dy > M) {
                    continue;
                }
                if (A[dx][dy] != 0) {
                    continue;
                }
                if (VISITED[dx][dy]) {
                    continue;
                }

                VISITED[dx][dy] = true;
                queue.add(dx);
                queue.add(dy);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0 && !VISITED[i][j]) {
                    cnt++;
                }
            }
        }
        ANS = Math.max(ANS, cnt);
    }
}
