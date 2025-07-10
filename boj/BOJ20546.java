package boj;

public class BOJ20546 {
    private static FastReader SC = new FastReader();
    private static int MONEY;
    private static int[] STOCK;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int bnp = getBNP();
        int timing = getTIMING();
//        System.out.println("bnp = " + bnp + " timing = " + timing);
        if (bnp > timing) {
            System.out.println("BNP");
        }
        else if (bnp < timing) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }

    private static int getTIMING() {
        int stock = 0;
        int money = MONEY;
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 0; i < STOCK.length; i++) {
            if (i != 0 && STOCK[i] < STOCK[i - 1]) {
                downCnt++;
            }
            else {
                downCnt = 0;
            }

            if (i != 0 && STOCK[i] > STOCK[i - 1]) {
                upCnt++;
            }
            else {
                upCnt = 0;
            }

            if (upCnt >= 3) {
                money += STOCK[i] * stock;
                stock = 0;
            }
            if (downCnt >= 3 && STOCK[i] <= money) {
                stock += money / STOCK[i];
                money -= STOCK[i] * (money / STOCK[i]);
            }
        }

        return stock * STOCK[13] + money;
    }

    private static int getBNP() {
        int stock = 0;
        int money = MONEY;
        for (int i = 0; i < 14; i++) {
            int num = money / STOCK[i];
            stock += num;
            money -= STOCK[i] * num;
        }

        int res = money + (STOCK[13] * stock);
        return res;
    }


    private static void input() {
        MONEY = SC.nextInt();
        STOCK = new int[14];
        for (int i = 0; i < 14; i++) {
            STOCK[i] = SC.nextInt();
        }
    }
}
