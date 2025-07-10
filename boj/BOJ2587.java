package boj;

import java.util.Arrays;

public class BOJ2587 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = SC.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += nums[i];
        }
        int mean = sum / 5;

        Arrays.sort(nums);
        int median = nums[5 / 2];

        System.out.println(mean);
        System.out.println(median);
    }
}
