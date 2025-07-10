package boj;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BOJ2623 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] INDEG;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        INDEG = new int[N + 1];
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            int x = sc.nextInt();
            int y;
            for (int j = 2; j <= cnt; j++) {
                y = sc.nextInt();
                ADJ[x].add(y);
                INDEG[y]++;
                x = y;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (INDEG[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            ans.add(x);
            for (int y : ADJ[x]) {
                INDEG[y]--;
                if (INDEG[y] == 0) {
                    queue.add(y);
                }
            }
        }

        if (ans.size() == N) {
            for (int x : ans) {
                sb.append(x).append('\n');
            }
        }
        else {
            sb.append(0);
        }

        System.out.println(sb);
    }
}
