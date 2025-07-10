package boj;

import java.util.*;

public class BOJ1541 {
    private static FastReader SC = new FastReader();
    private static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        STR = SC.nextLine();
    }

    private static void solve() {
        String[] split = STR.split("-");
        int res = 0;
        for (int i = 0; i < split.length; i++) {
            int sum = 0;
            for (String s : split[i].split("\\+")) {
                sum += Integer.parseInt(s);
            }

            if (i == 0) {
                res = sum;
            } else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
