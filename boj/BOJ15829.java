package boj;

import java.math.BigInteger;

public class BOJ15829 {
    static FastReader SC = new FastReader();
    static int L;
    static int R = 31;
    static int M = 1234567891;
    static char[] INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] converted = new int[INPUT.length];
        for (int i = 0; i < INPUT.length; i++) {
            converted[i] = INPUT[i] - 'a' + 1;
        }

        BigInteger res = calcHashFunc(converted);
        System.out.println(res);
    }

    private static BigInteger calcHashFunc(int[] nums) {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < nums.length; i++) {
            BigInteger sum_ = BigInteger.valueOf(nums[i]).multiply(BigInteger.valueOf(R).pow(i));
//            System.out.println(nums[i] + " " + sum_);
            sum = sum.add(sum_);
        }
        return sum.mod(BigInteger.valueOf(M));
    }

    private static void input() {
        L = SC.nextInt();
        INPUT = SC.next().toCharArray();
    }
}
