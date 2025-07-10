package boj;

public class BOJ1107 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] BUTTONS;
    private static int NUM;

    public static void main(String[] args) {
        input();
//        solve();
        solve2();
    }

    private static void solve2() {


        for (int i = 1; i <= 7; i++) {
            recFunc(0, i, "");
        }

//        System.out.println("num = " + NUM);
        long cnt = (long) Math.abs(N - NUM) + String.valueOf(NUM).length();
        System.out.println(Math.min(cnt, Math.abs(N - 100)));
    }

    private static void recFunc(int k, int len, String num) {
        if (k == len) {
            int n = Integer.parseInt(num);
//            System.out.println(n);
            if (Math.abs(N - n) < Math.abs(N - NUM)) {
                NUM = n;
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (BUTTONS[i] != -1) {
                    recFunc(k + 1, len, num + i);
                }
            }
        }
    }

    private static void solve() {
        int res = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBroken = false;
            for (int j = 0; j < len; j++) {
                if (BUTTONS[str.charAt(j) - '0'] == -1) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int min = Math.abs(N - i) + len;
                res = Math.min(res, min);
            }
        }

        System.out.println(res);
    }


    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        BUTTONS = new int[10];
        for (int i = 0; i < M; i++) {
            int n = SC.nextInt();
            BUTTONS[n] = -1;
        }
        NUM = Integer.MAX_VALUE;
    }
}
