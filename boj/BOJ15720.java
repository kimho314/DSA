package boj;

import java.util.Arrays;

public class BOJ15720 {
    static FastReader SC = new FastReader();
    static int B, C, D;
    static int[] BURGERS, SIDES, DRINKS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(BURGERS);
        Arrays.sort(SIDES);
        Arrays.sort(DRINKS);

        int originalTotalPrice = calcOriginalTotalPrice();
        int discountTotalPrice = originalTotalPrice;
        int maxSetCnt = Math.min(B, Math.min(C, D));
        for (int cnt = 0; cnt < maxSetCnt; cnt++) {
            int burgerIdx = B - 1 - cnt;
            int sideIdx = C - 1 - cnt;
            int drinkIdx = D - 1 - cnt;

            int sum = 0;
            sum += BURGERS[burgerIdx];
            sum += SIDES[sideIdx];
            sum += DRINKS[drinkIdx];

            int discount = (int) ((double) sum * 0.1);
            discountTotalPrice -= discount;
        }

        System.out.println(originalTotalPrice);
        System.out.println(discountTotalPrice);
    }

    private static int calcOriginalTotalPrice() {
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += BURGERS[i];
        }
        for (int i = 0; i < C; i++) {
            sum += SIDES[i];
        }
        for (int i = 0; i < D; i++) {
            sum += DRINKS[i];
        }
        return sum;
    }

    private static void input() {
        B = SC.nextInt();
        C = SC.nextInt();
        D = SC.nextInt();
        BURGERS = new int[B];
        SIDES = new int[C];
        DRINKS = new int[D];
        for (int i = 0; i < B; i++) {
            BURGERS[i] = SC.nextInt();
        }
        for (int i = 0; i < C; i++) {
            SIDES[i] = SC.nextInt();
        }
        for (int i = 0; i < D; i++) {
            DRINKS[i] = SC.nextInt();
        }
    }
}
