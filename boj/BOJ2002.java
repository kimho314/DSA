package boj;

import java.util.ArrayList;

public class BOJ2002 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<String> IN, OUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;

        while (!IN.isEmpty()) {
            if (!IN.get(0).equals(OUT.get(0))) {
                cnt++;
            }
            IN.remove(OUT.get(0));
            OUT.remove(0);
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        IN = new ArrayList<>();
        OUT = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            IN.add(SC.nextLine());
        }
        for (int i = 0; i < N; i++) {
            OUT.add(SC.nextLine());
        }
    }
}
