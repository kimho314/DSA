package boj;

public class BOJ20310 {
    static FastReader SC = new FastReader();
    static String S;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            SB.append(c);
            if (c == '0') {
                num0++;
            }
            else {
                num1++;
            }
        }

        num0 /= 2;
        num1 /= 2;

        for (int i = 0; i < SB.length(); i++) {
            if (SB.charAt(i) == '1') {
                SB.setCharAt(i, '2');
                num1--;
            }
            if (num1 == 0) {
                break;
            }
        }

        for (int i = SB.length() - 1; i >= 0; i--) {
            if (SB.charAt(i) == '0') {
                SB.setCharAt(i, '2');
                num0--;
            }
            if (num0 == 0) {
                break;
            }
        }

        for (int i = 0; i < SB.length(); i++) {
            if (SB.charAt(i) == '1' || SB.charAt(i) == '0') {
                System.out.print(SB.charAt(i));
            }
        }
    }

    private static void input() {
        S = SC.nextLine();
    }
}
