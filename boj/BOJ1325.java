package boj;

import java.util.*;

public class BOJ1325 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int CNT;

    public static void main(String[] args) {
        input();
        solve();
    }


    private static void solve() {
        int[] group = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(VISITED, false);
            CNT = 0;
            dfs(i);
            group[i] = CNT;
        }

        int max = 0;
        int maxIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (max < group[i]) {
                max = group[i];
                maxIdx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxIdx).append(" ");

        for (int i = 1; i <= N; i++) {
            if (i != maxIdx && max == group[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int x) {
        VISITED[x] = true;
        CNT++;
        for (int n : ADJ[x]) {
            if (!VISITED[n]) {
                dfs(n);
            }
        }

    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        CNT = 0;
        for (int i = 0; i < M; i++) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            ADJ[b].add(a);
        }
    }
}
