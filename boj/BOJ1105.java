package boj;

public class BOJ1105 {
    static FastReader SC = new FastReader();
    static int L, R;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        if (String.valueOf(L).length() == String.valueOf(R).length()) {
            String strL = String.valueOf(L);
            String strR = String.valueOf(R);
            for (int i = 0; i < strL.length(); i++) {
                if (strL.charAt(i) == '8' && strR.charAt(i) == '8') {
                    cnt++;
                }
                if (strL.charAt(i) != strR.charAt(i)) {
                    break;
                }
            }
        }

        System.out.println(cnt);
    }


    private static void input() {
        L = SC.nextInt();
        R = SC.nextInt();
    }
}
