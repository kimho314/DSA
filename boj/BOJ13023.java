package boj;

import java.util.*;

public class BOJ13023 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static boolean FLAG;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            if (FLAG) {
                break;
            }
            Arrays.fill(VISITED, false);
            dfs(i, 1);
        }

        if (FLAG) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int x, int cnt) {

        if (cnt == 5) {
            FLAG = true;
        } else {
            for (int n : ADJ[x]) {
                if (VISITED[n]) {
                    continue;
                }
                VISITED[x] = true;
                dfs(n, cnt + 1);
                VISITED[x] = false;
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        FLAG = false;
    }
}
