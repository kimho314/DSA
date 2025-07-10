package boj;

import java.util.ArrayList;
import java.util.Collections;

public class BOJ2785 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<Integer> CHAINS = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Collections.sort(CHAINS);

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            cnt = N - i - 1;
            sum += CHAINS.get(i);

            if (sum >= cnt) {
                break;
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            CHAINS.add(SC.nextInt());
        }
    }
}
