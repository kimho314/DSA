package boj;

import java.util.ArrayList;
import java.util.Collections;

public class BOJ24479 {
    static FastReader SC = new FastReader();
    static ArrayList<Integer>[] ADJ;
    static int[] VISITED;
    static int N, M, R, CNT = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(ADJ[i]);
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(VISITED[i]);
        }
    }

    private static void dfs(int start) {
        VISITED[start] = ++CNT;

        for (int x : ADJ[start]) {
            if (VISITED[x] > 0) {
                continue;
            }

            dfs(x);
        }
    }
}
