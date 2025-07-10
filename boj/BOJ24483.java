package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ24483 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static int[] VISITED;
    static ArrayList<Integer>[] ADJ;
    static int CNT = 0;
    static int[] ORDERS;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new int[N + 1];
        Arrays.fill(VISITED, -1);
        ORDERS = new int[N + 1];
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) {
            ADJ[i].sort(Comparator.naturalOrder());
        }
        dfs(R, 0);

        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += ((long) VISITED[i] * (long) ORDERS[i]);
        }
        System.out.println(res);
    }

    private static void dfs(int node, int cnt) {
        VISITED[node] = cnt;
        ORDERS[node] = ++CNT;

        for (int x : ADJ[node]) {
            int tmpCnt = cnt;
            if (VISITED[x] != -1) {
                continue;
            }

            dfs(x, ++tmpCnt);
        }
    }
}
