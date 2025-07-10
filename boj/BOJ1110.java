package boj;

public class BOJ1110 {
    static FastReader SC = new FastReader();
    static String N;

    public static void main(String[] args) {
        input();
        int res = solve();
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextLine();
    }

    private static int solve() {
        String str = N;
        int cnt = 0;
        while (true) {
            if (str.length() == 1) {
                str = "0" + str;
            }

            String first = String.valueOf(str.charAt(0));
            String second = String.valueOf(str.charAt(1));
            String sum1 = String.valueOf(Integer.parseInt(first) + Integer.parseInt(second));
            String sum2 = String.valueOf(str.charAt(str.length() - 1)) + String.valueOf(sum1.charAt(sum1.length() - 1));
            sum2 = String.valueOf(Integer.parseInt(sum2));
//            System.out.println(sum1 + " " + sum2);
            cnt++;
            if (sum2.equals(N)) {
                break;
            }
            str = sum2;
        }
        return cnt;
    }
}
