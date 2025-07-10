package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ24446 {
    static FastReader SC = new FastReader();
    static int N, M, R;
    static ArrayList<Integer>[] ADJ;
    static int[] VISITED;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new int[N + 1];
        Arrays.fill(VISITED, -1);
        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }

        bfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(VISITED[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        VISITED[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int n : ADJ[x]) {
                if (VISITED[n] != -1) {
                    continue;
                }

                VISITED[n] = VISITED[x] + 1;
                queue.add(n);
            }
        }
    }
}
