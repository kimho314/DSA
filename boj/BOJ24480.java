package boj;

import java.util.ArrayList;
import java.util.Comparator;

public class BOJ24480 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static boolean[] VISITED;
    static ArrayList<Integer>[] MAP;
    static int CNT = 0;
    static int[] ORDER;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new boolean[N + 1];
        ORDER = new int[N + 1];
        MAP = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            MAP[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            MAP[n1].add(n2);
            MAP[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            MAP[i].sort(Comparator.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(ORDER[i]);
        }
    }

    private static void dfs(int start) {
        VISITED[start] = true;
        ORDER[start] = ++CNT;

        for (Integer node : MAP[start]) {
            if (VISITED[node]) {
                continue;
            }

            dfs(node);
        }
    }
}
