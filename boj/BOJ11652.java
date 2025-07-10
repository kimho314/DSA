package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11652 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        long[] nums = new long[N + 1];
        for (int i = 0; i < N; i++) {
            nums[i + 1] = sc.nextLong();
        }

        Arrays.sort(nums, 1, N + 1);

        long mode = nums[1]; // 최빈값
        int modeCnt = 1; // 최빈값 등장 횟수
        int curCnt = 1; // 현재 값의 등장 횟수

        for (int i = 2; i <= N; i++) {
            if (nums[i] == nums[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = nums[i];
            }
        }

        System.out.println(mode);
    }
}
