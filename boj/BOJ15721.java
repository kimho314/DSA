package boj;

import java.util.*;

public class BOJ15721 {
    private static FastReader SC = new FastReader();
    private static int A, T, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        int b = 0;
        int d = 0;
        int n = 2;
        boolean isFound = false;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    b++;
                    if (b == T && C == 0) {
                        sb.append((b + d - 1) % A);
                        isFound = true;
                        break;
                    }
                } else {
                    d++;
                    if (d == T && C == 1) {
                        sb.append((b + d - 1) % A);
                        isFound = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                b++;
                if (b == T && C == 0) {
                    sb.append((b + d - 1) % A);
                    isFound = true;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                d++;
                if (d == T && C == 1) {
                    sb.append((b + d - 1) % A);
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                break;
            }
            n++;
        }

        System.out.println(sb);
    }

    private static void input() {
        A = SC.nextInt();
        T = SC.nextInt();
        C = SC.nextInt();
    }
}
