package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1005 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] INDEG, T_DONE, T;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        int Q = sc.nextInt();
        while (Q > 0) {
            Q--;
            input();
            process();
        }
        System.out.println(sb);
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (INDEG[i] == 0) {
                queue.add(i);
                T_DONE[i] = T[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : ADJ[x]) {
                INDEG[y]--;
                if (INDEG[y] == 0) {
                    queue.add(y);
                }
                T_DONE[y] = Math.max(T_DONE[y], T_DONE[x] + T[y]);
            }
        }

        int W = sc.nextInt();
        sb.append(T_DONE[W]).append('\n');
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        ADJ = new ArrayList[N + 1];
        INDEG = new int[N + 1];
        T = new int[N + 1];
        T_DONE = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
            T[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ADJ[x].add(y);
            // indegree 계산하기
            INDEG[y]++;
        }

    }
}
