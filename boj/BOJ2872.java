package boj;

import java.util.ArrayList;

public class BOJ2872 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<Integer> BOOKS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        int max = N;
        for (int i = BOOKS.size() - 1; i >= 0; i--) {
            if (BOOKS.get(i) == max) {
                max--;
                res++;
            }
        }

        System.out.println(N - res);
    }

    private static void input() {
        N = SC.nextInt();
        BOOKS = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            BOOKS.add(SC.nextInt());
        }
    }
}
