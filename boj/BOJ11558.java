package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11558 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int[] DIST;

    public static void main(String[] args) {
        input();

        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            ADJ = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                ADJ[i] = new ArrayList<>();
            }

            for (int i = 1; i <= n; i++) {
                int target = SC.nextInt();
                ADJ[i].add(target);
            }

            VISITED = new boolean[n + 1];
            DIST = new int[n + 1];
            bfs(1);

            sb.append(DIST[n]).append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (Integer x : ADJ[n]) {
                if (!VISITED[x]) {
                    VISITED[x] = true;
                    DIST[x] = DIST[n] + 1;
                    q.add(x);
                }
            }
        }
    }

    private static void input() {
        T = SC.nextInt();
    }
}
