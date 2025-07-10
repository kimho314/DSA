package boj;

import java.util.*;

public class BOJ4690 {
    private static FastReader SC = new FastReader();
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {}

    private static void solve() {
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= a; b++) {
                for (int c = b; c <= a; c++) {
                    for (int d = c; d <= a; d++) {
                        if (Math.pow(a, 3) == Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3)) {
                            SB.append("Cube = ").append(a).append(", Triple = ").append("(")
                                    .append(b).append(",").append(c).append(",").append(d)
                                    .append(")").append("\n");

                        }
                    }
                }
            }
        }

        System.out.println(SB);
    }
}
