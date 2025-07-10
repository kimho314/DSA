package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ3055 {
    static FastReader sc = new FastReader();
    static int N, M;
    static String[] A;
    static int[][] DIST_WATER, DIST_HEDGEHOG;
    static boolean[][] VISIT;
    static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine();
        }
        VISIT = new boolean[N][M];
        DIST_WATER = new int[N][M];
        DIST_HEDGEHOG = new int[N][M];

        bfsWater();
        bfsHedgehog();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i].charAt(j) == 'D') {
                    if (DIST_HEDGEHOG[i][j] == -1) {
                        System.out.println("KAKTUS");
                    }
                    else {
                        System.out.println(DIST_HEDGEHOG[i][j]);
                    }
                }
            }
        }
    }

    static void bfsWater() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DIST_WATER[i][j] = -1;
                VISIT[i][j] = false;
                if (A[i].charAt(j) == '*') {
                    queue.add(i);
                    queue.add(j);
                    DIST_WATER[i][j] = 0;
                    VISIT[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + DIR[k][0];
                int ny = y + DIR[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (A[nx].charAt(ny) != '.') {
                    continue;
                }
                if (VISIT[nx][ny]) {
                    continue;
                }

                queue.add(nx);
                queue.add(ny);
                VISIT[nx][ny] = true;
                DIST_WATER[nx][ny] = DIST_WATER[x][y] + 1;
            }
        }
    }

    static void bfsHedgehog() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DIST_HEDGEHOG[i][j] = -1;
                VISIT[i][j] = false;
                if (A[i].charAt(j) == 'S') {
                    queue.add(i);
                    queue.add(j);
                    DIST_HEDGEHOG[i][j] = 0;
                    VISIT[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + DIR[k][0];
                int ny = y + DIR[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (A[nx].charAt(ny) != '.' && A[nx].charAt(ny) != 'D') {
                    continue;
                }
                if (DIST_WATER[nx][ny] != -1 && DIST_WATER[nx][ny] <= DIST_HEDGEHOG[x][y] + 1) {
                    continue;
                }
                if (VISIT[nx][ny]) {
                    continue;
                }

                queue.add(nx);
                queue.add(ny);
                VISIT[nx][ny] = true;
                DIST_HEDGEHOG[nx][ny] = DIST_HEDGEHOG[x][y] + 1;
            }
        }
    }
}
