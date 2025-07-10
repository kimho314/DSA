package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ24482 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static ArrayList<Integer>[] ADJ;
    static int[] VISITED;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new int[N + 1];
        Arrays.fill(VISITED, -1);
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
            ADJ[i].sort(Comparator.reverseOrder());
        }
        dfs(R, 0);

        for (int i = 1; i <= N; i++) {
            System.out.println(VISITED[i]);
        }
    }

    private static void dfs(int node, int cnt) {
        VISITED[node] = cnt;

        for (int x : ADJ[node]) {
            int tmpCnt = cnt + 1;
            if (VISITED[x] != -1) {
                continue;
            }

            dfs(x, tmpCnt);
        }
    }
}
