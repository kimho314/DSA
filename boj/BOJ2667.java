package boj;

import java.util.*;

public class BOJ2667 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static ArrayList<Integer> GROUP;
    private static int CNT;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 1 && !VISITED[i][j]) {
                    CNT = 0;
                    dfs(i, j);
                    GROUP.add(CNT);
                }
            }
        }

        System.out.println(GROUP.size());
        GROUP.sort(Comparator.naturalOrder());
        for (int g : GROUP) {
            System.out.println(g);
        }
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                continue;
            }
            if (VISITED[dy][dx] || MAP[dy][dx] == 0) {
                continue;
            }
            dfs(dy, dx);
        }
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = SC.nextLine().split("");
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }
        VISITED = new boolean[N][N];
        GROUP = new ArrayList<>();
        CNT = 0;
    }

}
