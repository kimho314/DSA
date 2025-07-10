package boj;

import java.util.Arrays;

public class BOJ1253 {
    static int N;
    static int[] NUMS;
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        N = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }

        Arrays.sort(NUMS, 1, N + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isGood(int targetIdx) {
        int left = 1, right = N;
        int targetNum = NUMS[targetIdx];
        while (left < right) {
            if (left == targetIdx) {
                left++;
            }
            else if (right == targetIdx) {
                right--;
            }
            else {
                if (NUMS[left] + NUMS[right] < targetNum) {
                    left++;
                }
                else if (NUMS[left] + NUMS[right] > targetNum) {
                    right--;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}
