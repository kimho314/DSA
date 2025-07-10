package boj;

import java.util.Arrays;

public class BOJ3273 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] NUMS;
    static int X;

    public static void main(String[] args) {
        N = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }
        X = sc.nextInt();

        int cnt = 0;
        int left = 1;
        int right = N;

        Arrays.sort(NUMS);

        while (left < right) {
            if (NUMS[left] + NUMS[right] == X) {
                cnt++;
                right--;
            }
            else if (NUMS[left] + NUMS[right] > X) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(cnt);
    }
}
