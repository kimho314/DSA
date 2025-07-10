package boj;

public class BOJ1009 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            T--;
            int a = SC.nextInt();
            int b = SC.nextInt();

            int num = 1;
            for (int i = 0; i < b; i++) {
                num = (a * num) % 10;
                if (num == 0) {
                    num = 10;
                }
            }
            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
