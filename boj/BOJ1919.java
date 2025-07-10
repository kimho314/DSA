package boj;

public class BOJ1919 {
    static FastReader SC = new FastReader();
    static String STR1, STR2;
    static int[] CHAR_COUNT = new int[26];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < STR1.length(); i++) {
            CHAR_COUNT[STR1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < STR2.length(); i++) {
            CHAR_COUNT[STR2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int count : CHAR_COUNT) {
            ans += Math.abs(count);
        }
        System.out.println(ans);
    }

    private static void input() {
        STR1 = SC.nextLine();
        STR2 = SC.nextLine();
    }
}
