package boj;

import java.util.ArrayList;

public class BOJ1240 {
    static FastReader SC = new FastReader();
    static int N, M;
    static ArrayList<Node>[] ADJ;
    static int[] DIST;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    static class Node {
        int x;
        int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }


    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 0; i < ADJ.length; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            int x1 = SC.nextInt();
            int x2 = SC.nextInt();
            int w = SC.nextInt();
            ADJ[x1].add(new Node(x2, w));
            ADJ[x2].add(new Node(x1, w));
        }

        for (int i = 0; i < M; i++) {
            int start = SC.nextInt();
            int end = SC.nextInt();
            DIST = new int[N + 1];
            VISITED = new boolean[N + 1];
            dfs(start);
            SB.append(DIST[end]).append('\n');
        }

        System.out.println(SB);
    }

    private static void dfs(int start) {
        VISITED[start] = true;

        for (Node node : ADJ[start]) {
            if (VISITED[node.x]) {
                continue;
            }

            DIST[node.x] = DIST[start] + node.w;
            dfs(node.x);
        }
    }
}
