package boj;

public class BOJ1515 {
    static FastReader SC = new FastReader();
    static String INPUT;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        int idx = 0;
        int ans = 1;
        char[] arr = INPUT.toCharArray();

        while (idx < arr.length) {
            String num = Integer.toString(ans);

            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == arr[idx]) {
                    idx++;
                }
                if (idx >= arr.length) {
                    break;
                }
            }
            ans++;
        }

        System.out.println(ans - 1);
    }

    private static void init() {
        INPUT = SC.nextLine();
    }
}
