package boj;

public class BOJ2231 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i = 1; i < N; i++) {
            int num = getNum(i);
            // System.out.println(i + " " + num);
            if (num == N) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }

    private static int getNum(int n) {
        int res = n;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
            res += tmp;
        }
        return res;
    }

    private static void input() {
        N = SC.nextInt();
    }
}
