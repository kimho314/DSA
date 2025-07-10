package boj;

import java.util.ArrayList;

public class BOJ15681 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static ArrayList<Integer>[] con;
    static int[] Dy;

    public static void main(String[] args) {
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);
        }

        Dy = new int[N + 1];

        dfs(R, -1);

        for (int i = 1; i <= Q; i++) {
            int q = sc.nextInt();
            sb.append(Dy[q]).append('\n');
        }
        System.out.println(sb);
    }

    // Dy[x] 를 계산하는 함수
    static void dfs(int x, int prev) {
        Dy[x] = 1;
        for (int y : con[x]) {
            if (y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }
}
