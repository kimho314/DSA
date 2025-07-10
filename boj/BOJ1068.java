package boj;

import java.util.ArrayList;

public class BOJ1068 {
    static FastReader sc = new FastReader();
    static int N, ROOT, ERASED;
    static ArrayList<Integer>[] child;
    static int[] leaf;


    public static void main(String[] args) {
        N = sc.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                ROOT = i;
                continue;
            }
            child[parent].add(i);
        }
        ERASED = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (child[i].contains(ERASED)) {
                child[i].remove(child[i].indexOf(ERASED));
            }
        }

        if (ROOT != ERASED) {
            dfs(ROOT, -1);
        }

        System.out.println(leaf[ROOT]);
    }

    static void dfs(int x, int parent) {
        if (child[x].isEmpty()) {
            leaf[x]++;
        }
        for (int y : child[x]) {
            if (y == parent) {
                continue;
            }
            dfs(y, x);
            leaf[x] += leaf[y];
        }
    }
}
