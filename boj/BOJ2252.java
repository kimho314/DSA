package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2252 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] INDEG;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        INDEG = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ADJ[x].add(y);
            INDEG[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (INDEG[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y : ADJ[x]) {
                INDEG[y]--;
                if (INDEG[y] == 0) {
                    queue.add(y);
                }
            }
        }

        System.out.println(sb);
    }
}
