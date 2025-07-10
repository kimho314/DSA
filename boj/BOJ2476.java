package boj;

public class BOJ2476 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] DICES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            int[] nums = new int[7];
            for (int j = 0; j < 3; j++) {
                nums[DICES[i][j]]++;
            }

            int max = 0;
            for (int j = 6; j > 0; j--) {
                if (nums[j] == 3) {
                    res = Math.max(res, 10_000 + (j * 1_000));
                    break;
                }
                else if (nums[j] == 2) {
                    res = Math.max(res, 1_000 + (j * 100));
                    break;
                }
                else {
                    max = Math.max(max, j);
                }
            }

            if (res == 0) {
                res = Math.max(res, max * 100);
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        DICES = new int[N][3];
        for (int i = 0; i < N; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            int n3 = SC.nextInt();
            DICES[i][0] = n1;
            DICES[i][1] = n2;
            DICES[i][2] = n3;
        }
    }
}
