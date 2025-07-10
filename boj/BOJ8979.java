package boj;

import java.util.Arrays;

public class BOJ8979 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static Nation[] NATIONS;


    private static class Nation {
        public int rank;
        public int num;
        public int gold;
        public int silver;
        public int bronze;

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = 0;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(NATIONS, (o1, o2) -> {
            if (o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            } else if (o1.silver != o2.silver) {
                return o2.silver - o1.silver;
            } else {
                return o2.bronze - o1.bronze;
            }
        });

//        for (int i = 0; i < NATIONS.length; i++) {
//            System.out.println(NATIONS[i].num + " " + NATIONS[i].gold + " " + NATIONS[i].silver + " " + NATIONS[i].bronze);
//        }

        int rank = 1;
        NATIONS[0].rank = 1;
        for (int i = 1; i < NATIONS.length; i++) {
            if (NATIONS[i - 1].gold == NATIONS[i].gold
                    && NATIONS[i - 1].silver == NATIONS[i].silver
                    && NATIONS[i - 1].bronze == NATIONS[i].bronze) {
                NATIONS[i].rank = rank;
            } else {
                rank = i + 1;
                NATIONS[i].rank = rank;
            }
        }

        int res = 0;
        for (int i = 0; i < NATIONS.length; i++) {
            if (NATIONS[i].num == K) {
                res = NATIONS[i].rank;
                break;
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        NATIONS = new Nation[N];
        for (int i = 0; i < N; i++) {
            int n = SC.nextInt();
            int gold = SC.nextInt();
            int silver = SC.nextInt();
            int bronze = SC.nextInt();

            Nation nation = new Nation(n, gold, silver, bronze);
            NATIONS[i] = nation;
        }
    }
}
