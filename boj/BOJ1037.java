package boj;

import java.util.Arrays;

public class BOJ1037 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = SC.nextInt();
        }

        Arrays.sort(nums);
        int max = nums[N - 1];
        int min = nums[0];
        System.out.println(max * min);

    }
}
