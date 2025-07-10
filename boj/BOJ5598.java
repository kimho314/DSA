package boj;

public class BOJ5598 {
    private static FastReader SC = new FastReader();
    private static String WORD;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        char[] converted = new char[WORD.length()];

        for (int i = 0; i < WORD.length(); i++) {
            int ch = WORD.charAt(i) - 3;
            if (ch < 'A') {
                converted[i] = (char) ('Z' - ('A' - ch - 1));
            } else {
                converted[i] = (char) ch;
            }
//            System.out.println(ch + " " + converted[i]);
        }

        System.out.println(new String(converted));
    }

    private static void input() {
        WORD = SC.nextLine();
    }
}
