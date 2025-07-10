package boj;

public class BOJ8958 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(SB.toString());
    }

    private static void init() {
        T = SC.nextInt();
    }

    private static void solve() {
        while (T > 0) {
            T--;

            String str = SC.nextLine();
            int sum = calcSum(str);
            SB.append(sum).append('\n');
        }
    }

    private static int calcSum(String str) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'O') {
                ++cnt;
                sum += cnt;
            }
            else {
                cnt = 0;
            }
        }

        return sum;
    }
}
