package boj;

import java.util.*;

public class BOJ20164 {
    private static FastReader SC = new FastReader();
    private static String NUM;
    private static int MIN = Integer.MAX_VALUE;
    private static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        NUM = SC.nextLine();
    }

    private static void solve() {
        recFunc(NUM, 0);

        System.out.println(MIN + " " + MAX);
    }

    private static void recFunc(String num, int cnt) {
        int cntOdd = 0;
        for (String elem : num.split("")) {
            if (Integer.parseInt(elem) % 2 == 1) {
                cntOdd++;
            }
        }

        if (num.length() == 1) {
            MIN = Math.min(MIN, cnt + cntOdd);
            MAX = Math.max(MAX, cnt + cntOdd);
            return;
        } else {


            if (num.length() == 2) {
                String sub1 = num.substring(0, 1);
                String sub2 = num.substring(1);
                String tmp = String.valueOf(Integer.parseInt(sub1) + Integer.parseInt(sub2));
                // System.out.println("2" + " " + num + " " + sub1 + " " + sub2 + " " + tmp + " " +
                // cnt
                // + " " + cntOdd);
                recFunc(tmp, cnt + cntOdd);
            } else {
                for (int i = 1; i < num.length() - 1; i++) {
                    for (int j = i + 1; j < num.length(); j++) {
                        String sub1 = num.substring(0, i);
                        String sub2 = num.substring(i, j);
                        String sub3 = num.substring(j);
                        String tmp = String.valueOf(Integer.parseInt(sub1) + Integer.parseInt(sub2)
                                + Integer.parseInt(sub3));
                        // System.out.println("3" + " " + num + " " + sub1 + " " + sub2 + " " + sub3
                        // + " " + tmp + " " + cnt + " " + cntOdd);
                        recFunc(tmp, cnt + cntOdd);
                    }
                }
            }
        }
    }
}
