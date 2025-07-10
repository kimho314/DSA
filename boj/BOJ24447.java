package boj;

import java.util.*;

public class BOJ24447 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static int[] VISITED;
    static int[] ORDERS;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new int[N + 1];
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

        Arrays.fill(VISITED, -1);
        for (int i = 1; i <= N; i++) {
            ADJ[i].sort(Comparator.naturalOrder());
        }
        bfs(R);

        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += ((long) VISITED[i] * ORDERS[i]);
        }
        System.out.println(res);
    }

    private static void bfs(int start) {
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = 0;
        ORDERS[start] = cnt;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int n : ADJ[x]) {
                if (VISITED[n] != -1) {
                    continue;
                }

                queue.add(n);
                VISITED[n] = VISITED[x] + 1;
                ORDERS[n] = ++cnt;
            }
        }
    }
}
