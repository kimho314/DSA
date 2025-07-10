package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ24445 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static int CNT = 0;
    static boolean[] VISITED;
    static int[] ORDERS;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        VISITED = new boolean[N + 1];
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
            ADJ[i].sort(Comparator.comparingInt(value -> (int) value).reversed());
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(ORDERS[i]);
        }
    }

    private static void bfs(int start) {
        for (int i = 1; i <= N; i++) {
            VISITED[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;
        ORDERS[start] = ++CNT;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int x : ADJ[n]) {
                if (VISITED[x]) {
                    continue;
                }

                VISITED[x] = true;
                ORDERS[x] = ++CNT;
                queue.add(x);
            }
        }
    }
}
