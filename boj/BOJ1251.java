package boj;

import java.util.ArrayList;
import java.util.Collections;

public class BOJ1251 {
    private static FastReader SC = new FastReader();
    private static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < STR.length() - 1; i++) {
            for (int j = i + 1; j < STR.length(); j++) {
                StringBuilder sb = new StringBuilder();

                StringBuilder sb1 = new StringBuilder(STR.substring(0, i));
                StringBuilder sb2 = new StringBuilder(STR.substring(i, j));
                StringBuilder sb3 = new StringBuilder(STR.substring(j));

                sb.append(sb1.reverse())
                        .append(sb2.reverse())
                        .append(sb3.reverse());
                list.add(String.valueOf(sb));
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
