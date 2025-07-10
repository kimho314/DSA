package boj;

public class BOJ21313 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        boolean isOdd = N % 2 == 1;
        int max = isOdd ? N - 1 : N;
        for (int i = 0; i < max; i++) {
            if (i % 2 == 0) {
                sb.append('1').append(' ');
            }
            else {
                sb.append('2').append(' ');
            }
        }
        if (isOdd) {
            sb.append('3');
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
    }
}
