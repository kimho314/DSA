package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ24481 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static boolean[] VISITED;
    static ArrayList<Integer>[] ADJ;
    static int[] ORDERS;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new boolean[N + 1];
        ORDERS = new int[N + 1];
        Arrays.fill(ORDERS, -1);
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
        for (int i = 1; i <= N; i++) {
            System.out.println(ORDERS[i]);
        }
    }

    private static void dfs(int x, int cnt) {
        ORDERS[x] = cnt;
        VISITED[x] = true;

        for (int node : ADJ[x]) {
            if (VISITED[node]) {
                continue;
            }
            int tmpCnt = cnt;

            dfs(node, ++tmpCnt);
        }
    }
}
