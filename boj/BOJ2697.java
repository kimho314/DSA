package boj;

public class BOJ2697 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static String[] NUMS;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int t = 0; t < T; t++) {
            if (NUMS[t].length() == 1) {
                SB.append("BIGGEST").append("\n");
                continue;
            }

            int[] cnt = new int[10];

            int i = NUMS[t].length() - 2;
            for (; i >= 0; i--) {
                cnt[NUMS[t].charAt(i + 1) - '0']++;
                if (NUMS[t].charAt(i) < NUMS[t].charAt(i + 1)) {
                    cnt[NUMS[t].charAt(i) - '0']++;
                    break;
                }
            }

            if (i == -1) {
                SB.append("BIGGEST").append("\n");
                continue;
            }

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < i; j++) {
                answer.append(NUMS[t].charAt(j));
            }

            for (int j = (NUMS[t].charAt(i) - '0') + 1; j < cnt.length; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                answer.append((char) ('0' + j));
                cnt[j]--;
                break;
            }

            for (int j = 0; j < cnt.length; j++) {
                while (cnt[j]-- > 0) {
                    answer.append((char) ('0' + j));
                }
            }

            SB.append(answer).append("\n");
        }

        System.out.println(SB.toString());
    }


    private static void input() {
        T = SC.nextInt();
        NUMS = new String[T];
        for (int i = 0; i < T; i++) {
            NUMS[i] = SC.next();
        }
    }
}
