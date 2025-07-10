package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ24444 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int CNT = 1;
    static int[] CNT_GROUP;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        CNT_GROUP = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            ADJ[i].sort(Comparator.comparingInt(o -> o));
        }

        bfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(CNT_GROUP[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;
        CNT_GROUP[start] = CNT;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : ADJ[x]) {
                if (VISITED[y]) {
                    continue;
                }

                VISITED[y] = true;
                queue.add(y);
                CNT_GROUP[y] = ++CNT;
            }
        }
    }
}
