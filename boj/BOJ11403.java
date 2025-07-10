package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11403 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int N;
    static boolean[] VISITED;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        ADJ = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ADJ[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = SC.nextInt();
                if (input == 1) {
                    ADJ[i].add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            VISITED = new boolean[N];
            bfs(i);
        }
        System.out.println();
        System.out.println(SB);
    }

    private static void bfs(int start) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(start);
        VISITED[start] = false;

        while (!needVisit.isEmpty()) {
            int x = needVisit.poll();

            for (int y : ADJ[x]) {
                if (VISITED[y]) {
                    continue;
                }

                VISITED[y] = true;
                needVisit.add(y);
            }
        }

        for (int i = 0; i < N; i++) {
            SB.append(VISITED[i] ? 1 : 0).append(' ');
        }
        SB.append('\n');
    }
}
