package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2644 {
    static FastReader sc = new FastReader();
    static ArrayList<Integer>[] MAP;
    static int N, M;
    static int START, TARGET;
    static int[] DIST;
    static boolean[] VISITED;

    public static void main(String[] args) {
        N = sc.nextInt();
        START = sc.nextInt();
        TARGET = sc.nextInt();
        M = sc.nextInt();
        MAP = new ArrayList[N + 1];
        DIST = new int[N + 1];
        Arrays.fill(DIST, -1);
        VISITED = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            MAP[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            MAP[num1].add(num2);
            MAP[num2].add(num1);
        }

        bfs(START);
        System.out.println(DIST[TARGET]);
    }

    static void bfs(int start) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!needVisit.isEmpty()) {
            int num = needVisit.poll();

            for (int x : MAP[num]) {
                if (VISITED[x]) {
                    continue;
                }
                needVisit.add(x);
                VISITED[x] = true;
                DIST[x] = DIST[num] + 1;
            }
        }
    }
}