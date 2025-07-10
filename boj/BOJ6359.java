package boj;

import java.util.Arrays;

public class BOJ6359 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            boolean[] jail = new boolean[n + 1];
            Arrays.fill(jail, true);
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j % i == 0) {
                        jail[j] = !jail[j];
                    }
                }
//                System.out.println(i + " " + Arrays.toString(jail));
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (jail[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
