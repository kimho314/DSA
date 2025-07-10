package boj;

import java.util.ArrayList;

public class BOJ16206 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer> A;


    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        A.sort(((o1, o2) -> {
            if (o1 % 10 == 0 && o2 % 10 != 0) {
                return -1;
            }
            else if (o1 % 10 != 0 && o2 % 10 == 0) {
                return 1;
            }
            else {
                return o1 - o2;
            }
        }));

        int cnt = 0;
        for (Integer num : A) {
            if (num < 10) {
                continue;
            }

            if (num == 10) {
                cnt++;
            }
            else {
                while (num > 10 && M > 0) {
                    M--;
                    num -= 10;
                    cnt++;
                }
                if (num == 10) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(SC.nextInt());
        }
    }
}
