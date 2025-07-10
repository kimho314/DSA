package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1389 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] DIST;
    static boolean[] VISITED;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
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

        int minNum = Integer.MAX_VALUE;
        int minPerson = 1;
        for (int i = 1; i <= N; i++) {
            VISITED = new boolean[N + 1];
            DIST = new int[N + 1];

            // through BFS get all DIST
            bfs(i);

            // calculate bacom's number
            int num = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                num += DIST[j];
            }

            // determin if the bacon's number is minimum number
            if (minNum > num) {
                minNum = num;
                minPerson = i;
            }
        }
        System.out.println(minPerson);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (int x : ADJ[node]) {
                if (VISITED[x]) {
                    continue;
                }

                VISITED[x] = true;
                DIST[x] = DIST[node] + 1;
                queue.add(x);
            }
        }
    }
}
