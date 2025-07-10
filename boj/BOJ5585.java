package boj;

public class BOJ5585 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int remainder = 1000 - N;
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        int cnt = 0;

        for (int coin : coins) {
            int num = remainder / coin;
            cnt += num;
            remainder -= (num * coin);
        }

        System.out.println(cnt);
    }
}
