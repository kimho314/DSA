package boj;

public class BOJ11059 {
    private static FastReader SC = new FastReader();
    private static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int max = 0;
        for (int i = 0; i < INPUT.length() - 1; i++) {
            for (int j = i + 1; j < INPUT.length(); j += 2) {
                if (determine(i, j)) {
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        System.out.println(max);
    }

    private static boolean determine(int start, int end) {
        int sum1 = 0;
        int mid = (end + start) / 2;
        for (int i = start; i <= mid; i++) {
            sum1 += Integer.parseInt(String.valueOf(INPUT.charAt(i)));
        }
        int sum2 = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum2 += Integer.parseInt(String.valueOf(INPUT.charAt(i)));
        }
//        System.out.println(start + " " + end + " " + INPUT.charAt(start) + " " + INPUT.charAt(end) + " " + sum1 + " " + sum2);
        return sum1 == sum2;
    }

    private static void input() {
        INPUT = SC.next();
    }
}
