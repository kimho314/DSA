package boj;

import java.util.Arrays;

public class BOJ5586 {
    private static FastReader SC = new FastReader();
    private static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cntJOI = 0;
        int cntIOI = 0;

        char[] ch = STR.toCharArray();
        for (int i = 0; i < ch.length - 2; i++) {
            char[] sub = Arrays.copyOfRange(ch, i, i + 3);
            String str = new String(sub);
            if (str.equals("JOI")) {
                cntJOI++;
            }
            if (str.equals("IOI")) {
                cntIOI++;
            }
        }

        System.out.println(cntJOI);
        System.out.println(cntIOI);
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
