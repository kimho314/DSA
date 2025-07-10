package boj;

import java.util.ArrayList;
import java.util.Comparator;

public class BOJ1018 {
    static FastReader SC = new FastReader();
    static int N, M;
    static String[][] MAP;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = SC.nextLine().split("");
            for (int j = 0; j < M; j++) {
                MAP[i][j] = split[j];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for (int idx1 = i; idx1 < i + 8; idx1++) {
                    for (int idx2 = j; idx2 < j + 8; idx2++) {
                        if ((idx1 + idx2) % 2 == 0) {
                            if (!MAP[idx1][idx2].equals("B")) {
                                cnt1++;
                            }
                            if (!MAP[idx1][idx2].equals("W")) {
                                cnt2++;
                            }
                        }
                        else {
                            if (!MAP[idx1][idx2].equals("W")) {
                                cnt1++;
                            }
                            if (!MAP[idx1][idx2].equals("B")) {
                                cnt2++;
                            }
                        }
                    }
                }
                list.add(cnt1);
                list.add(cnt2);
            }
        }

        int res = list.stream().min(Comparator.comparingInt(it -> it)).get();
        System.out.println(res);
    }
}
