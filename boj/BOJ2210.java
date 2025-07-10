package boj;

import java.util.HashSet;
import java.util.Set;

public class BOJ2210 {
    static FastReader SC = new FastReader();
    static int[][] MAP = new int[5][5];
    static Set<String> set = new HashSet<>();
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] STR = new int[6];

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1);
            }
        }
        System.out.println(set.size());
    }

    private static void dfs(int y, int x, int cnt) {
        if (cnt > 6) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                str.append(STR[i]);
            }
//            System.out.println(str.toString());
            set.add(str.toString());
        }
        else {
            STR[cnt - 1] = MAP[y][x];
            for (int i = 0; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= 5 || dx >= 5) {
                    continue;
                }

                dfs(dy, dx, cnt + 1);
            }
        }
    }
}
