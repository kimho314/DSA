package boj;

public class BOJ2495 {
    private static FastReader SC = new FastReader();
    private static String[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int max = 0;
            for (int j = 0; j < NUMS[i].length(); j++) {
                int cnt = 0;
                for (int k = j; k < NUMS[i].length(); k++) {
                    if (NUMS[i].charAt(j) != NUMS[i].charAt(k)) {
                        break;
                    }
                    ++cnt;
                }
                max = Math.max(max, cnt);
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        NUMS = new String[3];
        for (int i = 0; i < 3; i++) {
            NUMS[i] = SC.nextLine();
        }
    }

}
