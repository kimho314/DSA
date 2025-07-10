package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ9470 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int T, K, M, P;
    static int[] INDEG;
    static int[] ORDER;
    static int[] MAX_CNT;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        T = sc.nextInt();
        while (T > 0) {
            T--;
            input();
            process();
        }
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (INDEG[i] == 0) {
                queue.add(i);
                ORDER[i] = 1;
                MAX_CNT[i] = 1;
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (MAX_CNT[x] >= 2) {
                ORDER[x]++;
            }

            ans = Math.max(ans, ORDER[x]);

            for (int y : ADJ[x]) {
                INDEG[y]--;
                if (INDEG[y] == 0) {
                    queue.add(y);
                }

                // Stahler 순서 계산을 위해서 y번 정점에 들어오는 최대 순서를 갱신해준다.
                if (ORDER[y] == ORDER[x]) {
                    MAX_CNT[y]++;
                }
                if (ORDER[y] < ORDER[x]) {
                    ORDER[y] = ORDER[x];
                    MAX_CNT[y] = 1;
                }
            }
        }
        System.out.println(K + " " + ans);
    }

    private static void input() {
        K = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        INDEG = new int[M + 1];
        ORDER = new int[M + 1];
        MAX_CNT = new int[M + 1];
        ADJ = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 0; i < P; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ADJ[a].add(b);
            INDEG[b]++;
        }
    }
}
