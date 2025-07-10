package boj;

public class BOJ10987 {
    static FastReader SC = new FastReader();
    static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 0; i < INPUT.length(); i++) {
            if (isVowel(INPUT.charAt(i))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    private static void input() {
        INPUT = SC.next();
    }
}
