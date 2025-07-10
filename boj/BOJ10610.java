package boj;

import java.util.Arrays;

public class BOJ10610 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static String N;
    static char[] NUMS;

    public static void main(String[] args) {
        N = SC.nextLine();
        NUMS = N.toCharArray();
        Arrays.sort(NUMS);

        int sum = 0;
        for (int i = NUMS.length - 1; i >= 0; i--) {
            int num = NUMS[i] - '0';
            sum += num;
            SB.append(num);
        }

        if (sum % 3 != 0 || NUMS[0] != '0') {
            System.out.println(-1);
            return;
        }

        System.out.println(SB);
    }

}
