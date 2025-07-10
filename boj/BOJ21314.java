package boj;

import java.util.*;

public class BOJ21314 {
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
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean flag = false;

        String big = bigNum(sb, flag, cnt);
        String small = smallNum(sb, flag, cnt);

        System.out.println(big);
        System.out.println(small);
    }

    private static String bigNum(StringBuilder sb, boolean flag, int cnt) {
        for (int i = 0; i < STR.length(); i++) {
            char ch = STR.charAt(i);
            if (!flag && ch == 'K') {
                sb.append(5);
            }
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(5).append("0".repeat(cnt));
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0) {
            sb.append("1".repeat(cnt));
        }

        return sb.toString();
    }

    private static String smallNum(StringBuilder sb, boolean flag, int cnt) {
        sb.setLength(0);
        flag = false;
        cnt = 0;

        for (int i = 0; i < STR.length(); i++) {
            char ch = STR.charAt(i);
            if (!flag && ch == 'K') {
                sb.append(5);
            }
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(1).append("0".repeat(cnt - 1)).append(5);
                flag = false;
                cnt = 0;
            }
        }

        if (cnt != 0) {
            sb.append(1).append("0".repeat(cnt - 1));
        }
        return sb.toString();
    }
}
