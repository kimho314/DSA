package boj;

public class BOJ2578 {
    private static FastReader SC = new FastReader();
    private static int[][] MAP;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;

        for (int i = 0; i < 25; i++) {
            int n = NUMS[i];
            for (int h = 0; h < 5; h++) {
                for (int w = 0; w < 5; w++) {
                    if (MAP[h][w] == n) {
                        MAP[h][w] = -1;
                    }
                }
            }

            if (i >= 5) {
                int cntOfBingo = countBingo();
                if (cntOfBingo >= 3) {
                    res = i + 1;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    private static int countBingo() {
        int totalCount = 0;

        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (MAP[i][j] == -1) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                totalCount++;
            }
        }

        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (MAP[j][i] == -1) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                totalCount++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (MAP[i][i] == -1) {
                cnt++;
            }
        }
        if (cnt == 5) {
            totalCount++;
        }

        cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (MAP[5 - i - 1][i] == -1) {
                cnt++;
            }
        }
        if (cnt == 5) {
            totalCount++;
        }

        return totalCount;
    }

    private static void input() {
        MAP = new int[5][5];
        NUMS = new int[25];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
