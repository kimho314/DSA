package boj;

import java.util.ArrayList;

public class BOJ10451 {
    static FastReader SC = new FastReader();
    static int T;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int CNT = 0;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            CNT = 0;
            int n = SC.nextInt();
            ADJ = new ArrayList[n + 1];
            VISITED = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                ADJ[i] = new ArrayList<>();
            }
            for (int i = 1; i <= n; i++) {
                int input = SC.nextInt();
                ADJ[i].add(input);
            }

            for (int i = 1; i <= n; i++) {
                if (!VISITED[i]) {
                    dfs(i, i);
                }
            }

            SB.append(CNT).append('\n');
        }
        System.out.println(SB.toString());
    }

    private static void dfs(int node, int start) {
        VISITED[node] = true;

        for (Integer n : ADJ[node]) {
            if (n == start) {
                CNT++;
                break;
            }

            if (VISITED[n]) {
                continue;
            }
            dfs(n, start);
        }
    }
}
