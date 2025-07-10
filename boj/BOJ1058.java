package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1058 {
    static FastReader SC = new FastReader();
    static int N;
    static String[][] MAP;
    static boolean[] VISITED;
    static int[] DIST;
    static int MAX_CNT = 0;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        MAP = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = SC.nextLine().split("");
            if (N >= 0) {
                System.arraycopy(split, 0, MAP[i], 0, N);
            }
        }
        ADJ = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ADJ[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (MAP[i][j].equals("Y")) {
                    ADJ[i].add(j);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            DIST = new int[N];
            VISITED = new boolean[N];

            bfs(i);

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (DIST[j] == 1 || DIST[j] == 2) {
                    cnt++;
                }
            }
            MAX_CNT = Math.max(MAX_CNT, cnt);
        }
        System.out.println(MAX_CNT);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int x : ADJ[node]) {
                if (VISITED[x]) {
                    continue;
                }

                VISITED[x] = true;
                DIST[x] = DIST[node] + 1;
                q.add(x);
            }
        }
    }
}
