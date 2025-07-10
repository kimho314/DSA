package boj;

public class BOJ2490 {
    private static FastReader SC = new FastReader();
    private static int[][] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                if (NUMS[i][j] == 1) {
                    sum++;
                }
            }

            if (sum == 4) {
                sb.append("E");
            }
            else if (sum == 3) {
                sb.append("A");
            }
            else if (sum == 2) {
                sb.append("B");
            }
            else if (sum == 1) {
                sb.append("C");
            }
            else {
                sb.append("D");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        NUMS = new int[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                NUMS[i][j] = SC.nextInt();
            }
        }
    }
}
