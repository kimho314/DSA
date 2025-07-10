package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ4963 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int W, H;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
    static int GROUP_CNT;
    static List<Integer> GROUP;

    public static void main(String[] args) {
        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();
            if (W == 0 && H == 0) {
                break;
            }
            MAP = new int[H][W];
            VISITED = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    int num = sc.nextInt();
                    MAP[i][j] = num;
                }
            }

            process();
        }

        System.out.println(sb);
    }

    private static void process() {
        GROUP = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!VISITED[i][j] && MAP[i][j] == 1) {
                    GROUP_CNT = 0;
                    dfs(i, j);
                    GROUP.add(GROUP_CNT);
                }
            }
        }
        sb.append(GROUP.size()).append('\n');
    }

    private static void dfs(int x, int y) {
        VISITED[x][y] = true;
        GROUP_CNT++;

        for (int[] ints : DIR) {
            int dx = x + ints[0];
            int dy = y + ints[1];
            if (dx < 0 || dy < 0 || dx >= H || dy >= W) {
                continue;
            }
            if (VISITED[dx][dy]) {
                continue;
            }
            if (MAP[dx][dy] == 0) {
                continue;
            }
            dfs(dx, dy);
        }
    }
}
